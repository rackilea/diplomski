package com.example;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DayDifference {

    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = sdf.parse("2016-02-28");
        Date d2 = sdf.parse("2016-03-01");

        long diff = (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24);

        System.out.println("diff: " + diff);
    }
}