import org.threeten.bp.Duration;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.LocalTime;
import org.threeten.bp.Period;
import org.threeten.bp.format.DateTimeFormatter;

String time1 = "2017-06-18 07:00:00"; // set time
String curtime = "2017-06-19 07:00:01"; // get the current time

// parse the strings to a date object
DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
LocalDateTime t1 = LocalDateTime.parse(time1, fmt);
LocalDateTime cur = LocalDateTime.parse(curtime, fmt);

// get the period between the dates
LocalDate startDate = t1.toLocalDate();
LocalDate endDate = cur.toLocalDate();
Period period = Period.ZERO;
if (startDate != null && endDate != null) {
    period = Period.between(startDate, endDate);
}

// get the duration between the dates
LocalTime startTime = t1.toLocalTime();
LocalTime endTime = cur.toLocalTime();
startTime = startTime != null ? startTime : LocalTime.MIDNIGHT;
endTime = endTime != null ? endTime : LocalTime.MIDNIGHT;
Duration duration = Duration.between(startTime, endTime);

StringBuilder sb = new StringBuilder();
append(sb, period.getYears(), "year");
append(sb, period.getMonths(), "month");
append(sb, period.getDays(), "day");
long seconds = duration.getSeconds();
long hours = seconds / 3600;
append(sb, hours, "hour");
seconds -= (hours * 3600);
long minutes = seconds / 60;
append(sb, minutes, "minute");
seconds -= (minutes * 60);
append(sb, seconds, "second");

System.out.println(sb.toString()); // 1 day 1 second

// auxiliary method
public void append(StringBuilder sb, long value, String text) {
    if (value > 0) {
        if (sb.length() > 0) {
            sb.append(" ");
        }
        sb.append(value).append(" ");
        sb.append(text);
        if (value > 1) {
            sb.append("s"); // append "s" for plural
        }
    }
}