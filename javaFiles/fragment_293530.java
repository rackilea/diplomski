import java.util.*;
import org.joda.time.*;
import org.joda.time.format.*;

class Test {
    public static void main(String[] args) {        
        DateTimeFormatter format = DateTimeFormat
            .forPattern("EEE MMM dd HH:mm:ss Z yyyy")
            .withLocale(Locale.ENGLISH);

        String input = "Mon Feb 10 18:52:54 +0000 2014";

        DateTime value = format.parseDateTime(input);
        System.out.println(format.print(value));
    }
}