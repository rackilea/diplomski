import org.joda.time.*;
import org.joda.time.format.*;

public class Test {
    public static void main(String[] args) {
        String startText = "PT0S";
        String endText = "PT21M12.667S";

        PeriodFormatter format = ISOPeriodFormat.standard();
        Period start = format.parsePeriod(startText);
        Period end = format.parsePeriod(endText);

        Duration duration = end.minus(start).toStandardDuration();
        System.out.println(duration); // PT1272.667S
        System.out.println(duration.getMillis()); // 1272667
    }
}