package test;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Test2 {

    public static void main(String[] args) throws ParseException {

        LocalDateTime date1 = LocalDateTime.parse("2019-05-22T18:58:56");
        LocalDateTime date2 = LocalDateTime.parse("2019-05-23T19:00:00"); //LocalDateTime.now();

        long seconds = ChronoUnit.SECONDS.between(date1, date2);

        System.out.println(seconds);
    }

}