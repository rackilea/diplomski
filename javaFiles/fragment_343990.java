import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class testcc {

    public static void main(String[] args) {
        // String input = "Wed Jul 02 00:00:00 PST 2014";
        String input = "Wed Jul 02 12:00:00 GMT-400 2014";
        int pos = input.indexOf('-');
        if (pos == -1)
            pos = input.indexOf('+');
        if (pos != -1) {
            input = input.substring(0, pos + 2) + ":"
                    + input.substring(pos + 2, input.length());
        }

        DateFormat df = new SimpleDateFormat("EEE MMM d kk:mm:ss z yyyy", Locale.ENGLISH);
        Date date = null;
        try {
            date = df.parse(input);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        DateFormat dfTarget = new SimpleDateFormat("dd-MMM-yyy");
        System.out.println(dfTarget.format(date));
    }
}