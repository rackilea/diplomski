import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

    public static Date parseDate(String dateAsString, SimpleDateFormat[] formats, int i) {
        if (i == formats.length) {
            return null;
        }
        try {
            return formats[i].parse(dateAsString);
        } catch (ParseException e) {
            return parseDate(dateAsString, formats, i + 1);
        }
    }

    public static void main(String[] args) {
        SimpleDateFormat[] formats = { new SimpleDateFormat("EEEE, MMMM d, yyyy h:mm a"), new SimpleDateFormat("EEEE, d MMMM, yyyy H:mm"), new SimpleDateFormat("dd.MM.yy") };
        String[] datesAsStrings = {"Sunday, November 15, 2015 7:00 PM", "Saturday, 14 November, 2015 22:04", "25.07.15", "this is NOT a date"};
        for(String dateAsString :datesAsStrings){
            System.out.println(parseDate(dateAsString, formats, 0));
        }
    }
}