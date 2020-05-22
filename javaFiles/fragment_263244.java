import org.joda.time.*;
import org.joda.time.format.*;

public class Test
{    
    public static void main(String[] args)
    {
        DateTimeZone zone = DateTimeZone.forID("Europe/London");        
        DateTimeFormatter format = DateTimeFormat.mediumDateTime();

        long current = System.currentTimeMillis();
        for (int i=0; i < 100; i++)
        {
            long next = zone.nextTransition(current);
            if (current == next)
            {
                break;
            }
            System.out.println (format.print(next) + " Into DST? " 
                                + !zone.isStandardOffset(next));
            current = next;
        }
    }
}