import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        String inputDate = "2014-07-04T12:08:56.235-07:00";
        String inputFormat = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";

        String outputFormat = "dd MM HH:mm";

        // Input formatter
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern(inputFormat);

        // Time after formatting
        LocalDateTime dateTime = LocalDateTime.parse(inputDate, inputFormatter);

        // Output formatter
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern(outputFormat);

        // Output date as String
        String outputDate = dateTime.format(outputFormatter);

        System.out.println(outputDate);
    }
}