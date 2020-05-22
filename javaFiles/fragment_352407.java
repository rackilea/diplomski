import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/** @see http://stackoverflow.com/a/14675418/230513 */
public class TestSDF {

    private static final String s = "dd-MMM-yyyy HH:mm:ss zz";
    private static final DateFormat f = new SimpleDateFormat(s);

    public static void main(String[] args) {
        Date date = new Date();
        print("GMT", date);
        print("America/New_York", date);
        print("America/Aruba", date);
        print("America/Buenos_Aires", date);
        print("America/Sao_Paulo", date);
        print("Atlantic/Azores", date);
        print("Europe/London", date);
        print("Europe/Berlin", date);
    }

    private static void print(String tz, Date d) {
        f.setTimeZone(TimeZone.getTimeZone(tz));
        System.out.println(f.format(d)
            + " " + tz
            + " " + d.getTime());
    }
}