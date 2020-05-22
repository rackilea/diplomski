public class Test {
    private final static long MILLIS_IN_DAY = 86400 * 1000;

    public static void main(String[] args) {
        Calendar nowCal = new GregorianCalendar();
        setTime(nowCal, 29, 1, 2011, 0, 0, 0);
        Calendar maxOffsetCal = new GregorianCalendar();
        setTime(maxOffsetCal, 2, 2, 2011, 23, 59, 59);
        long now = nowCal.getTimeInMillis(), endTime = maxOffsetCal.getTimeInMillis();
        for (; now < endTime; now += MILLIS_IN_DAY ) {
            System.out.println(new Date(now));
        }
    }

    private static void setTime(Calendar c, int dayOfMonth, int monthOfYear, int year,
                                    int hourOfDay, int minute, int second) {
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        c.set(Calendar.MONTH, monthOfYear - 1);
        c.set(Calendar.YEAR, year);
        c.set(Calendar.HOUR_OF_DAY, hourOfDay);
        c.set(Calendar.MINUTE, minute);
        c.set(Calendar.SECOND, second);
        c.set(Calendar.MILLISECOND, 0);
    }
}