import java.time.*;
import java.time.format.*;
import java.util.*;

public class Test {

    public static void main(String[] args) {
        String dateFormat = "HH:mm:ss MM/dd/uuuu";
        String dateString = "11:30:59 02/31/2015";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter
            .ofPattern(dateFormat, Locale.US)
            .withResolverStyle(ResolverStyle.STRICT);
        try {
            LocalDateTime date = LocalDateTime.parse(dateString, dateTimeFormatter);
            System.out.println(date);
        } catch (DateTimeParseException e) {
            // Throw invalid date message
            System.out.println("Exception was thrown");
        }
    }
}