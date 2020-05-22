import static org.joda.time.DateTimeConstants.NOVEMBER;
import static org.joda.time.DateTimeConstants.WEDNESDAY;
import static org.joda.time.DateTimeFieldType.dayOfMonth;
import static org.joda.time.DateTimeFieldType.dayOfWeek;
import static org.joda.time.DateTimeFieldType.hourOfDay;
import static org.joda.time.DateTimeFieldType.monthOfYear;
import static org.joda.time.Duration.standardDays;
import static org.joda.time.Duration.standardHours;

import org.joda.time.Duration;
import org.joda.time.Partial;

public class Periods {

    public static void main(String[] args) {

        // "1 hour" (all/any 1 hour period)
        Duration d1 = standardHours(1);
        Partial p1 = new Partial();

        // "1 hour, starting 1pm" (all/any 1 hour periods that start at 1pm)
        Duration d2 = standardHours(1);
        Partial p2 = new Partial().withField(hourOfDay(), 13);

        // "1 hour, starting 1pm, on Wednesdays" (all/any 1 hour periods that start at 1pm on Eednesdays)
        Duration d3 = standardHours(1);
        Partial p4 = new Partial().withField(hourOfDay(), 13).withField(hourOfDay(), 1).withField(dayOfWeek(), WEDNESDAY);

        // "1 hour, starting 1pm, on Wednesday in November"
        Duration d4 = standardHours(1);
        Partial p3 = new Partial().withField(hourOfDay(), 13).withField(hourOfDay(), 1).withField(dayOfWeek(), WEDNESDAY).withField(monthOfYear(), NOVEMBER);

        // "1 week, starting the first week in November"
        Duration d5 = standardDays(7);
        Partial p5 = new Partial().withField(dayOfMonth(), 1).withField(monthOfYear(), NOVEMBER);
    }

}