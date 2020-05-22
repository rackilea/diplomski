import java.time.*;
import java.time.format.*;
import java.time.temporal.*;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        // TODO: Build this map up programmatically instead?            
        Map<Long, String> monthNames = new HashMap<>();
        monthNames.put(1L, "JANUARY");
        monthNames.put(2L, "FEBRUARY");
        monthNames.put(3L, "MARCH");
        monthNames.put(4L, "APRIL");
        monthNames.put(5L, "MAY");
        monthNames.put(6L, "JUNE");
        monthNames.put(7L, "JULY");
        monthNames.put(8L, "AUGUST");
        monthNames.put(9L, "SEPTEMBER");
        monthNames.put(10L, "OCTOBER");
        monthNames.put(11L, "NOVEMBER");
        monthNames.put(12L, "DECEMBER");

        // Note: this would probably be a field somewhere so you don't need
        // to build it every time.
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
            .appendText(ChronoField.MONTH_OF_YEAR, monthNames)
            .appendLiteral(' ')
            .appendPattern("yyyy")
            .toFormatter(Locale.US);

        YearMonth month = YearMonth.parse("FEBRUARY 2019", formatter);
        System.out.println(month);
    }
}