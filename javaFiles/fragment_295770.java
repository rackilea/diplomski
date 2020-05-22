import org.joda.time.*;
import org.joda.time.format.*;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        String text = "05:00";

        PeriodFormatter formatter = new PeriodFormatterBuilder()
            .minimumPrintedDigits(2)
            .appendMinutes()
            .appendSeparator(":")
            .appendSeconds()
            .toFormatter();

        Period milePeriod = formatter.parsePeriod(text);

        long mileMillis = milePeriod.toStandardDuration().getMillis();
        long kmMillis = Math.round(mileMillis * 0.623712);

        PeriodType minutesSeconds = PeriodType.time()
            .withMillisRemoved()
            .withHoursRemoved();

        Period kmPeriod = new Period(kmMillis, minutesSeconds);

        System.out.println(formatter.print(kmPeriod)); // Prints 03:07
    }
}