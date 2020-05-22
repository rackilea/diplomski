import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;

class Scratch {

    public static void main(String[] args) {
        String stringDate = "Jan 1, 2019 11:00:00 PM";
        stringDate = stringDate.replace("AM", "vorm.");
        stringDate = stringDate.replace("PM", "nachm.");
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendPattern("LLL d, yyyy hh:mm:ss a")
                .toFormatter(Locale.GERMANY);
        LocalDateTime localDateTime = LocalDateTime.parse(stringDate, formatter);
        LocalDate localDate = LocalDate.parse(stringDate, formatter);
    }

}