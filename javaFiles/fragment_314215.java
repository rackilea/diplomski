import java.util.*;

public class Test {
    public static void main(String[] args) throws Exception {
        TimeZone zone = TimeZone.getTimeZone("Europe/Paris");
        Calendar calendar = new GregorianCalendar(zone);
        // Month 8 = September in 0-based month numbering
        calendar.set(2014, 8, 5, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        System.out.println(calendar.getTimeInMillis());
    }
}