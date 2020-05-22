import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Calendar calendar=Calendar.getInstance();
        String formatString=getTheCurrentLocaleDateTimeFormatString();
        System.out.println(formatString);
        SimpleDateFormat dateFormat = new SimpleDateFormat(formatString);
        String localeTimeString= dateFormat.format(calendar.getTimeInMillis());
        System.out.println(localeTimeString);
    }

    static String getTheCurrentLocaleDateTimeFormatString() {
        return ((SimpleDateFormat) DateFormat.getDateInstance(DateFormat.FULL, Locale.getDefault())).toLocalizedPattern();
    }
}