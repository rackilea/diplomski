import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = getTheCurrentLocaleDateTimeFormatString();
        String localeTimeString = dateFormat.format(calendar.getTimeInMillis());
        System.out.println(localeTimeString);
    }

    static SimpleDateFormat getTheCurrentLocaleDateTimeFormatString() {
        return (SimpleDateFormat) DateFormat.getDateInstance(DateFormat.FULL, Locale.getDefault());
    }
}