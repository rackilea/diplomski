public int getHoursInDay(LocalDate date, DateTimeZone zone) {
    DateTime start = date.toDateTimeAtStartOfDay(zone);
    DateTime end = date.plusDays(1).toDateTimeAtStartOfDay(zone);
    long millis = new Duration(start, end).getMillis();
    return (int) (millis / DateTimeConstants.MILLIS_PER_HOUR);
}