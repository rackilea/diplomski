import java.util.Calendar;

public class Main {

    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();

        cal.set(Calendar.HOUR_OF_DAY, 20);
        cal.set(Calendar.MINUTE, 58);

        long minutes = (cal.getTimeInMillis() - Calendar.getInstance().getTimeInMillis()) / 1000 / 60;

        System.out.println(minutes);
    }

}