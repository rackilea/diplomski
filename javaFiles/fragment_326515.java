import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        String input = "Mon Sep 25 13:40:56 GMT+05:30 2017";
        String dateFormat = "EEE MMM d HH:mm:ss z yyyy";
        try {
            Date date = new SimpleDateFormat(dateFormat).parse(input);
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}