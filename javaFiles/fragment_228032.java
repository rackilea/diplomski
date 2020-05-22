import java.util.*;
import java.time.*;
import java.time.format.*;

public class Test {

    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("Europe/London"));
        Date date = new Date(2017 - 1900, 3 - 1, 26, 1, 30);

        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime ldt = LocalDateTime.ofInstant(instant, zone);
        System.out.println(ldt); // Use ISO-8601 by default
    }
}