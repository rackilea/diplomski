import java.util.*;

public class Test {

    private static final long TICKS_AT_EPOCH = 621355968000000000L;
    private static final long TICKS_PER_MILLISECOND = 10000;

    public static void main(String[] args) {
        long ticks = 634200192000000000L;

        Date date = new Date((ticks - TICKS_AT_EPOCH) / TICKS_PER_MILLISECOND);
        System.out.println(date);

        TimeZone utc = TimeZone.getTimeZone("UTC");
        Calendar calendar = Calendar.getInstance(utc);
        calendar.setTime(date);
        System.out.println(calendar);
    }
}