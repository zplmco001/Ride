package iride.app.com.iride;

import android.os.Environment;
import android.util.Log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

/**
 * Created by mehmetcanolgun on 22.04.2019.
 */

public class FileWrite {

    private List<SatisInfo> list;
/** DOSYA SİLME KALDIRILDI  **/
    FileWrite(List<SatisInfo> list){
        this.list = list;
    }


    public boolean isOldDay(){
        if (list.size()>0){
            String kayitTarihi = list.get(0).kayitTarihi;
            Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
            int day = calendar.get(Calendar.DATE);
            int month = calendar.get(Calendar.MONTH) + 1;
            int year = calendar.get(Calendar.YEAR);

            int modus =2000;

            if(year%modus!=0){
                year=year%modus;
            }else{
                modus+=1000;
                year=year%modus;
            }

            String today;
            if(day<10){

                if(month<10){
                    today = "0"+day+"/0"+month+"/"+year;
                }else{
                    today = "0"+day+"/"+month+"/"+year;
                }

            }else if(month<10){
                today = day+"/0"+month+"/"+year;
            }else{
                today = day+"/"+month+"/"+year;
            }
            Log.e("today",today);
            Log.e("kayit",kayitTarihi);
            if (today.equals(kayitTarihi)){
                return false;
            }else {
                return true;
            }
        }
        else {
            return false;
        }
    }



}
