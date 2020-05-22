package com.javacodegeeks.drools;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;


global String topicLevel
rule "Drools Introduction"
when
$droolsIntro : DroolsIntroduction( topic == "Drools" )
then
System.out.println($droolsIntro.introduceYourself() + ", topic level is " + getDefaultIfNull(topicLevel));
end

rule "Drools Introduction2"
when
$droolsIntro : DroolsIntroduction( isTimeBetweenTwoTime("10:12:12","13:13:13","11:12:12") && isExcludeDay("000000","2016-08-08 21:5:21") )
then
System.out.println("time valid and sunday");
end

function String getDefaultIfNull(String topicLevel) {
return topicLevel == null ? "Moderate" : topicLevel;
}

function Boolean isTimeBetweenTwoTime(String initialTime, String finalTime, String currentTime) {
        Boolean valid = false;
        System.out.println("time check started");
        try {
            if (currentTime == null) {
                currentTime = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
                System.out.println("check current time "+currentTime);
            }
            System.out.println(initialTime+" -- "+finalTime+" -- -- "+currentTime);
            String reg = "^([0-1][0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$";
            if (initialTime.matches(reg) && finalTime.matches(reg) && currentTime.matches(reg)) {
                valid = false;
                // Start Time
                java.util.Date inTime = new SimpleDateFormat("HH:mm:ss").parse(initialTime);
                Calendar initialTimecalendar1 = Calendar.getInstance();
                initialTimecalendar1.setTime(inTime);
                // Current Time
                java.util.Date checkTime = new SimpleDateFormat("HH:mm:ss").parse(currentTime);
                Calendar currentTimecalendar3 = Calendar.getInstance();
                currentTimecalendar3.setTime(checkTime);
                // End Time
                java.util.Date finTime = new SimpleDateFormat("HH:mm:ss").parse(finalTime);
                Calendar finalTimecalendar2 = Calendar.getInstance();
                finalTimecalendar2.setTime(finTime);
                if (finalTime.compareTo(initialTime) < 0) {
                     finalTimecalendar2.add(Calendar.DATE, 1);
                     currentTimecalendar3.add(Calendar.DATE, 1);
                }
                java.util.Date actualTime = currentTimecalendar3.getTime();
                if ((actualTime.after(initialTimecalendar1.getTime())
                        || actualTime.compareTo(initialTimecalendar1.getTime()) == 0)
                        && actualTime.before(finalTimecalendar2.getTime())) {
                    System.out.println("condition matched --- ");
                    valid = true;
                }
                System.out.println("returning "+valid);
                return valid;
            } else {
                System.out.println("else false "+valid);
                return valid;
                // throw new IllegalArgumentException("not a valid time,
                // expecting HH:MM:SS format");
            }
        } catch (Exception e) {
            System.out.println("exception "+valid);
            valid=false;
        }
        System.out.println("finale "+valid);
        return valid;
    }
    function Boolean isExcludeDay(String validdays,String timeStamp) {
        try {
            System.out.println("validdays"+validdays);
            System.out.println("timeStamp"+timeStamp);
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        Date date = format.parse(timeStamp);
        Calendar currentTimecalendar3 = Calendar.getInstance();
        currentTimecalendar3.setTime(date);
        int dayOfWeek = currentTimecalendar3.get(Calendar.DAY_OF_WEEK)-1;
        Character  a_char = validdays.charAt(dayOfWeek);
        System.out.println( a_char );
        if(a_char.compareTo('1')==0){
            return false;
        }else{
            return true;
        }
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
            return false;
        }
        //return true;
        //return true;
    }