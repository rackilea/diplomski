import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class scratch_21 {
    public static void main(String[] args) {
        System.out.println(verifyIfInside("14:00:00", "14:15:00"));
    }

    private static boolean verifyIfInside(String min, String max) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

            Date date = new Date();

            String hora1 = min;
            String hora2 = max;
            String newHour = dateFormat.format(date);

            Date minHour, maxHour, nowHour;
            minHour = dateFormat.parse(hora1);
            maxHour = dateFormat.parse(hora2);
            nowHour = dateFormat.parse(newHour);

            return  nowHour.after(minHour) && nowHour.before(maxHour);
        } catch (ParseException parseException) {
            parseException.printStackTrace();
            return false;
        }
    }
}