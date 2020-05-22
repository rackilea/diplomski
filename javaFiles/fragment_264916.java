import java.text.*;
import java.util.*;

class Test {
    public static void main(String[] args) {
        SimpleDateFormat sd = new SimpleDateFormat(
            "yyyy.MM.dd G 'at' HH:mm:ss z");
        Date date = new Date();
        // TODO: Avoid using the abbreviations when fetching time zones.
        // Use the full Olson zone ID instead.
        sd.setTimeZone(TimeZone.getTimeZone("IST"));
        System.out.println(sd.format(date));
   }
}