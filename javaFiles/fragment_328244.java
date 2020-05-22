import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DaysBetween {

    public static void main(String[] args) {
        LocalDate lastLogin = LocalDate.of(2017, 4, 1);
        LocalDate today = LocalDate.now();
        System.out.println(daysBetween(lastLogin, today));
    }

    private static long daysBetween(LocalDate from, LocalDate to) {
        return ChronoUnit.DAYS.between(from, to);
    }
}