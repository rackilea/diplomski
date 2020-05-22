import java.text.ParseException;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class mydate {

    public static void main(String[] args) throws ParseException {
        // TODO Auto-generated method stub

        java.util.Date date = new DateTime("2014-08-12T05:43:00-05:00").toDate();
        DateTime dateTimeUtc = new DateTime( date, DateTimeZone.UTC ); // Joda-Time can convert from java.util.Date type which has no time zone.
        String output = dateTimeUtc.toString().replace("-", "").replace("T", "").replace(":", "").substring(0,14)+"Z"; // Defaults to ISO 8601 format.
        System.out.println(output);

    }

}