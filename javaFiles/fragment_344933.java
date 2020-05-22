import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CustomFormattedDate {

    public static void main(String[] args) {
        Date date = new Date();
        // if you use DD for Daypattern, you'll get the day of the year, e.g. 119 for the
        // 29th April 2014, if you want 29, the day of the month, use dd
        SimpleDateFormat df = new SimpleDateFormat("YYYY-dd-MMM", new Locale(System.getProperty("user.language")));
        System.out.println(df.format(date));

        System.out.println(getDateFormat().format(date));
    }
}