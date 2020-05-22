import org.joda.*;
import org.joda.time.*;

// interval from start to end
DateTime start = new DateTime(2004, 12, 25, 0, 0, 0, 0);
DateTime end = new DateTime(2005, 1, 1, 0, 0, 0, 0);
Interval interval = new Interval(start, end);
Period period = interval.toPeriod();
System.out.println(period.getYears() + " years, " + period.getMonths() + " months, " + period.getWeeks() + " weeks, " + period.getDays() + ", days");