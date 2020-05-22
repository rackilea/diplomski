public static final Calendar beforeFirstCalendar;
static {
    beforeFirstCalendar = GregorianCalendar.getInstance();
    beforeFirstCalendar.set(1776, 6, 4, 0, 0, 1);
}
public static final Date beforeFirstDate = beforeFirstCalendar.getTime();