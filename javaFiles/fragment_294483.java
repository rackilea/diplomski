import org.joda.time.*;
import org.joda.time.format.*;

public class Test {
    public static void main(String[] args) {
        String text = "2016-06-01T14:46:22.001Z";
        DateTime dt = ISODateTimeFormat.dateTime()
            .withZone(DateTimeZone.UTC)
            .parseDateTime(text);
        System.out.println(dt);
    }
}