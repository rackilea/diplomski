public static Date nthWeekdayOfMonth(int dayOfWeek, int month, int year, int week, TimeZone timeZone) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeZone(timeZone);
    calendar.set(Calendar.DAY_OF_WEEK, dayOfWeek);
    //calendar.set(Calendar.WEEK_OF_MONTH, week);
    calendar.set(Calendar.DAY_OF_WEEK_IN_MONTH, week);
    calendar.set(Calendar.MONTH, month);
    calendar.set(Calendar.YEAR, year);
    return calendar.getTime();
}