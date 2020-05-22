import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public static void main(final String[] args) {

    // Just so you know it in the future. Not needed in this example.
    final DateTimeFormatter dtfDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.US);

    final DateTimeFormatter dtfTime = DateTimeFormatter.ofPattern("HH:mm:ss", Locale.US);

    final LocalTime ltStart = LocalTime.of(10, 24, 49);
    final LocalTime ltEnd = ltStart.plusHours(1);

    // If you want to use String parsing to get your instance:
    final LocalTime ltStartViaParsing = LocalTime.from(dtfTime.parse("10:24:49"));

    LocalTime i = ltStart;
    while (i.isBefore(ltEnd)) {

        System.out.println("result i = " + dtfTime.format(i));
        i = i.plusSeconds(1);
    }
}