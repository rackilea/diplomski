package com.test.date;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.bind.DatatypeConverter;

public class DateAdapter {
    private DateAdapter() {
    }

    public static String marshal(Date date) {
        System.out.println("Inside marshal");
        Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(date);
        return DatatypeConverter.printDateTime(cal);
    }

    public static Date unmarshal(String xmlDate) {
        System.out.println("Inside unmarshal");
        return DatatypeConverter.parseDate(xmlDate).getTime();
    }

}