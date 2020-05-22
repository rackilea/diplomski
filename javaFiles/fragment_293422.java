package ovv.ant.threetenbp;

import java.util.Date;

import org.threeten.bp.Instant;
import org.threeten.bp.DateTimeUtils;

public class AntAndThreeTenBackportDemo {

    public static void main(String... commandLineArguments) {
        Instant once = Instant.parse("1939-11-19T16:30:00Z");
        Date oldfashionedDateObject = DateTimeUtils.toDate(once);
        System.out.println("As Date: " + oldfashionedDateObject);
    }

}