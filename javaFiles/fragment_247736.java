package com.ggl.testing;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FormatDate {

    private static final DateFormat inputDateFormat =
            new SimpleDateFormat("dd-MM-yyyy");
    private static final DateFormat outputDateFormat = 
            new SimpleDateFormat("yyyy-MM-dd HH:mm");

    private Calendar calendar;

    public String previousDateString(String dateString) 
            throws ParseException {
        Calendar now = Calendar.getInstance();

        calendar = Calendar.getInstance();
        Date myDate = inputDateFormat.parse(dateString);
        calendar.setTime(myDate);
        calendar.set(Calendar.HOUR_OF_DAY, 
                now.get(Calendar.HOUR_OF_DAY));
        calendar.set(Calendar.MINUTE, 
                now.get(Calendar.MINUTE));

        return outputDateFormat.format(calendar.getTime());
    }

    public static void main(String[] args) {
        String dateString = "10-06-2014";
        try {
            String output = 
                    new FormatDate().previousDateString(dateString);
            System.out.println(output);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}