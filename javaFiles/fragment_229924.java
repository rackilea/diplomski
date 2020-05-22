/**
 * @param date the date in the format "yyyy-MM-dd"
 */
public long getStartOfDayInMillis(String date) throws ParseException {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    Calendar calendar = Calendar.getInstance();
        calendar.setTime(format.parse(date));
    calendar.set(Calendar.HOUR_OF_DAY, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    calendar.set(Calendar.MILLISECOND, 0);
    return calendar.getTimeInMillis();
}

/**
 * @param date the date in the format "yyyy-MM-dd"
 */
public long getEndOfDayInMillis(String date) throws ParseException {
    // Add one day's time to the beginning of the day.
    // 24 hours * 60 minutes * 60 seconds * 1000 milliseconds = 1 day
    return getStartOfDayInMillis(date) + (24 * 60 * 60 * 1000);
}