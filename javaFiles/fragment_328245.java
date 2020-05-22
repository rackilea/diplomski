import java.time.temporal.ChronoUnit;
import java.util.Calendar;

public class DaysBetween {

    public static void main(String[] args) {
        Calendar lastLogin = Calendar.getInstance();
        lastLogin.set(Calendar.YEAR, 2017);
        lastLogin.set(Calendar.MONTH, 3);
        lastLogin.set(Calendar.DAY_OF_MONTH, 1);
        Calendar today = Calendar.getInstance();
        System.out.println(daysBetween(lastLogin, today));
    }

    private static long daysBetween(Calendar from, Calendar to) {
        return ChronoUnit.DAYS.between(from.toInstant(), to.toInstant());
    }
}