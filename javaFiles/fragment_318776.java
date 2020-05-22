package com.dd;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.LocalDate;

public class MyDate {

    private Date date;

    public MyDate(Request req) {
        int day = req.getParameter("dd");
        int month = req.getParameter("mm");
        int year = req.getParameter("yyyy");
        date = new LocalDate(year, month, day).toDate();
    }

    public String format(String givenFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(givenFormat);
        return sdf.format(date);
    }

}