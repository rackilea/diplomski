import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DayOfYear 
{
    public static void main(String args[])
    {
       Calendar localCalendar = Calendar.getInstance(TimeZone.getDefault());
       int CurrentDayOfYear = localCalendar.get(Calendar.DAY_OF_YEAR);
       System.out.println("Day of Year: " + CurrentDayOfYear);
       Calendar gmtCalendar = 
       Calendar.getInstance(TimeZone.getTimeZone("GMT"));
    }
}