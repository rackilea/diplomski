package com.sandbox;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Sandbox {

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        try {
            Date start = sdf.parse("00:44:16");
            Date end = sdf.parse("04:02:39");
            long duration = end.getTime() - start.getTime();
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(duration);
            System.out.println(new SimpleDateFormat("yyyy MM dd HH:mm:ss").format(cal.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}