import java.util.Calendar;
import java.util.TimeZone;

public class Main {
    public static void main(String[] args) {
        Calendar calender = Calendar.getInstance();

        calender.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));

        System.out.println(calender.get(Calendar.HOUR_OF_DAY) + ":" + calender.get(Calendar.MINUTE) +  ":" + calender.getActualMinimum(Calendar.SECOND));
    }
}