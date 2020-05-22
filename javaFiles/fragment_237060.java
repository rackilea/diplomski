import java.util.*;
import java.time.*;
import java.time.format.*;
import java.time.chrono.*;
import java.time.temporal.*;

public class ZonedDateTimeTest {

    public static void main(String[] args) {
        printYearAndWeekOfYear("2049-01-02T03:48:00Z");
        String instantStr2 = "2049-12-31T03:48:00Z";
        printYearAndWeekOfYear("2049-12-31T03:48:00Z");
    }

    public static void printYearAndWeekOfYear(String isoDate) {
        System.out.println("Date provided -> " + isoDate);

        Instant instant = DateTimeFormatter.ISO_OFFSET_DATE_TIME.parse(isoDate, Instant::from);
        ZonedDateTime utcTimestamp = instant.atZone(ZoneOffset.UTC);
        int year = utcTimestamp.get(IsoFields.WEEK_BASED_YEAR);
        int weekOfYear = utcTimestamp.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);
        System.out.println("ZonedDateTime: Year " + year + " weekOfYear " + weekOfYear);

        // Force the Gregorian calendar with ISO rules and using UTC
        Calendar calendar = new GregorianCalendar();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.setMinimalDaysInFirstWeek(4);
        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
        calendar.setTime(Date.from(instant));

        int calYear = calendar.getWeekYear();
        int calWeekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
        System.out.println("Calendar: Year " + calYear + " weekOfYear " + calWeekOfYear);
        System.out.println();
    }
}