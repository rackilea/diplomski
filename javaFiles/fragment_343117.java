import java.time.*;
import java.time.format.*;
import java.time.temporal.*;

class Example
{
    private static void showDateInfo(LocalDate ld) {
        int weekOfYear = ld.get(ChronoField.ALIGNED_WEEK_OF_YEAR);
        int dayOfWeek = ld.getDayOfWeek().getValue();
        System.out.println(ld.format(DateTimeFormatter.ISO_LOCAL_DATE) + " is week " + weekOfYear + ", day " + dayOfWeek);
    }
    public static void main (String[] args) throws java.lang.Exception
    {
        LocalDate currentLocalDate = LocalDate.of(2019, 6, 30);
        showDateInfo(currentLocalDate);
        int dayOfWeek = currentLocalDate.getDayOfWeek().getValue();
        int weekOfYear = currentLocalDate.get(ChronoField.ALIGNED_WEEK_OF_YEAR);
        LocalDate resultLocalDate = currentLocalDate
            .minusYears(1)
            .with(ChronoField.ALIGNED_WEEK_OF_YEAR, weekOfYear)
            .with(ChronoField.DAY_OF_WEEK, dayOfWeek);
        showDateInfo(resultLocalDate);
    }
}