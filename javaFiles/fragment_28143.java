package com.sandbox;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Sandbox {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Date parsed = format.parse("20110210");
        java.sql.Date sql = new java.sql.Date(parsed.getTime());
    }


}