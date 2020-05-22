import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormats {

    public static String frenchDate() {
        String timeStamp = new SimpleDateFormat("EEE MMM dd hh:mm:ss yyyy", Locale.FRANCE)
            .format(new Date());
        return timeStamp;
    }

    public static void main(String[] args) {
        System.out.println(frenchDate());
    }
}