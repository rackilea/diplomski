import org.joda.time.DateTime;
import org.joda.time.Duration;

DateTime today = new DateTime();
DateTime yesterday = today.minusDays(1);

Duration duration = new Duration(yesterday, today);
System.out.println(duration.getStandardDays());