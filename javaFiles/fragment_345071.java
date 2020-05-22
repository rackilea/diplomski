import java.util.*;
import org.joda.time.*;

public class Test
{
    public static void main(String[] args)
    {
        List<LocalDate> dates = getWeekendDates
            (new LocalDate(2011, 1, 1), new LocalDate(2011, 12, 1));
        for (LocalDate date : dates)
        {
            System.out.println(date);
        }
    }

    private static List<LocalDate> getWeekendDates
        (LocalDate start, LocalDate end)
    {
        List<LocalDate> result = new ArrayList<LocalDate>();
        for (LocalDate date = start;
             date.isBefore(end);
             date = date.plusDays(1))
        {
            int day = date.getDayOfWeek();
            // These could be passed in...
            if (day == DateTimeConstants.SATURDAY ||
                day == DateTimeConstants.SUNDAY)
            {
                result.add(date);
            }
        }
        return result;
    }                                            
}