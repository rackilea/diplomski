package com.example;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TestClient {

    /**
     * @param args
     */
    public static void main(String[] args) {
        long time = 1427723278405L;
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        System.out.println(sdf.format(new Date(time)));

    }

}