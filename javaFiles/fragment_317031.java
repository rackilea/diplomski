import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
public class App 
 {
    public static void main(String[] args) {
        String[] candidates =
            {"2016-11-21T15:54:51.841Z",
                 "2016-11-21T09:54:51.841-06:00",
                    "2016", // Java8 no can do?
                    "2016-11", // Java8 no can do?
                    "2016-11-21", // Java8 no can do?
                    "2016-11-21T01", // Java8 no can do?
                    "2016-11-21T01:02", // Java8 no can do?
                    "2016-11-21T01:02:03" // Java8 no can do?*/
            };

        DateTimeFormatter customOffsetDateTimeFormatter = new DateTimeFormatterBuilder().appendPattern("yyyy[-MM][-dd['T'HH[:mm[:ss]]]][.SSSXXX]")
            .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
            .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
            .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
            .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
            .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
            .parseDefaulting(ChronoField.NANO_OF_SECOND, 0)
            .parseDefaulting(ChronoField.OFFSET_SECONDS, ZoneOffset.of("-06:00").getTotalSeconds())
            .toFormatter();

    org.joda.time.format.DateTimeFormatter jodaDateTimeFormatter = ISODateTimeFormat.dateTimeParser();
    for (String candidate : candidates) {
        System.out.println("\ncandidate:\t\"" + candidate + "\"");
        DateTime jodaDateTime = jodaDateTimeFormatter.parseDateTime(candidate);
        System.out.println("Joda:\t" + jodaDateTime);
        try {
            OffsetDateTime java8OffsetDateTime = OffsetDateTime.parse(candidate,customOffsetDateTimeFormatter);
            System.out.println("Java8:\t" + java8OffsetDateTime);
            long jodaMillis = jodaDateTime.getMillis();
            long javaMillis = java8OffsetDateTime.toInstant().toEpochMilli();
            System.out.printf("jodaMillis:%d %s javaMillis:%d\n",
                    jodaMillis,
                    (jodaMillis == javaMillis) ? "==" : "!=",
                    javaMillis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}