import org.threeten.extra.PeriodDuration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

String time1 = "2017-06-18 07:00:00"; // set time
String curtime = "2017-06-19 07:00:01"; // get the current time

DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
LocalDateTime t1 = LocalDateTime.parse(time1, fmt);
LocalDateTime cur = LocalDateTime.parse(curtime, fmt);

PeriodDuration pd = PeriodDuration.between(t1, cur);

StringBuilder sb = new StringBuilder();
append(sb, pd.getPeriod().getYears(), "year");
append(sb, pd.getPeriod().getMonths(), "month");
append(sb, pd.getPeriod().getDays(), "day");
long seconds = pd.getDuration().getSeconds();
long hours = seconds / 3600;
append(sb, hours, "hour");
seconds -= (hours * 3600);
long minutes = seconds / 60;
append(sb, minutes, "minute");
seconds -= (minutes * 60);
append(sb, seconds, "second");

System.out.println(sb.toString()); // 1 day 1 second