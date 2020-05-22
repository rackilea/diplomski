import java.time.*;
import java.time.format.*;

public class Test {    
    public static void main(String args[]) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_TIME;
        LocalTime time = LocalTime.parse("00:00",formatter);
        LocalDate date = LocalDate.of(2000, 1, 1);
        LocalDateTime dateTime = date.atTime(time);
        System.out.println(dateTime); // 2000-01-01T00:00
    }
}