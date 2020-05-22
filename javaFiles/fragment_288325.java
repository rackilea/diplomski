import java.time.*;
import java.util.*;

public class Test {
    public static void main (String args[]) {
        GregorianCalendar test = new GregorianCalendar();
        test.setGregorianChange(new Date(Long.MIN_VALUE));
        test.set(Calendar.DAY_OF_MONTH, 31);
        test.set(Calendar.MONTH, 11);
        test.set(Calendar.YEAR, 1600);
        test.add(Calendar.DAY_OF_MONTH,-583657);
        Date date = test.getTime();
        Instant instant = Instant.ofEpochMilli(date.getTime());
        System.out.println(date);
        System.out.println(instant);
    }
}