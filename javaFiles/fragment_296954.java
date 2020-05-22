import java.time.*;
import java.time.format.*;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        // Note: this would probably be a field somewhere so you don't need
        // to build it every time.
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
            .parseCaseInsensitive()
            .appendPattern("MMMM yyyy")
            .toFormatter(Locale.US);

        YearMonth month = YearMonth.parse("FEBRUARY 2019", formatter);
        System.out.println(month);
    }
}