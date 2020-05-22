private static Calendar cacheCalendar;

public static int getFirstMonday(int year, int month) {
    cacheCalendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
    cacheCalendar.set(Calendar.DAY_OF_WEEK_IN_MONTH, 1);
    cacheCalendar.set(Calendar.MONTH, month);
    cacheCalendar.set(Calendar.YEAR, year);
    return cacheCalendar.get(Calendar.DATE);
}

public static int getFirstMonday(int year) {
    return getFirstMonday(year, Calendar.JANUARY);
}