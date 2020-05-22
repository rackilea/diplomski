package main_program;

import java.text.ParseException;
import java.text.SimpleDateFormat;  
import java.util.Date;
import java.sql.Timestamp;

public class testing2 {
    public static void main( String[] args) {
        SimpleDateFormat format = new SimpleDateFormat(" EEE MMM dd HH:mm:ss zzz yyyy ");
        String time = " Wed Dec 14 00:00:00 CST 2012 ";
        Date date = null; 
        try {
            date = format.parse(time);
        } catch (ParseException e1) {
            e1.printStackTrace();
        }
        try {
            System.out.println("Format To times:"); 
            System.out.println(date.getTime());
            Timestamp ts = new Timestamp(date.getTime());
            System.out.println(ts);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}