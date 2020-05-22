import java.util.*;
import org.joda.time.*;

public class ChinaTest {
    public static void main(String[] args) {
        DateTime startOf1900 = new DateTime(1900, 1, 1, 0, 0, 0, DateTimeZone.UTC);
        DateTime endOf1899 = startOf1900.minusMillis(1);

        DateTimeZone jodaZone = DateTimeZone.forID("Asia/Shanghai");
        System.out.println("Joda at start of 1900: " +
                           jodaZone.getOffset(startOf1900));
        System.out.println("Joda at end of 1899: " +
                           jodaZone.getOffset(endOf1899));
        TimeZone javaZone = TimeZone.getTimeZone("Asia/Shanghai");
        System.out.println("Java at start of 1900: " + 
                           javaZone.getOffset(startOf1900.getMillis()));
        System.out.println("Java at end of 1899: " + 
                           javaZone.getOffset(startOf1900.getMillis() - 1));
    }
}