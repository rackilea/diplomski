import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.ZoneId;

class Testing {
  public static void main(String[] args) {
    DateTimeFormatterBuilder dtfb =
      new DateTimeFormatterBuilder()
        .appendPattern("yyyy.dd.MM[ HH:mm:ss]")
        .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
        .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
        .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0);

    String timeStr = "1997.10.10";
//    String timeStr = "1997.10.10 00:00:01";
//    String timeStr = "1997.10.10 23:45:23";

    Long instant =
      dtfb.toFormatter().withZone(ZoneId.of("America/New_York"))
          .parse(timeStr)
          .getLong(ChronoField.INSTANT_SECONDS);

    System.out.println(instant);
  }
}