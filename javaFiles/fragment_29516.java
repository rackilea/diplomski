import java.time.LocalTime;
import static java.time.temporal.ChronoUnit.MINUTES;

public class SO {
    public static void main(String[] args) {
        LocalTime l1 = LocalTime.parse("02:53:40");
        LocalTime l2 = LocalTime.parse("02:54:27");
        System.out.println(l1.until(l2, MINUTES));
        System.out.println(MINUTES.between(l1, l2));
    }
}