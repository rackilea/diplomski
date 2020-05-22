private Date shiftTimeZone(Date date, TimeZone sourceTimeZone, TimeZone targetTimeZone) {
    Calendar sourceCalendar = Calendar.getInstance();
    sourceCalendar.setTime(date);
    sourceCalendar.setTimeZone(sourceTimeZone);

    Calendar targetCalendar = Calendar.getInstance();
    for (int field : new int[] {Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH, Calendar.HOUR, Calendar.MINUTE, Calendar.SECOND, Calendar.MILLISECOND}) {
        targetCalendar.set(field, sourceCalendar.get(field));
    }
    targetCalendar.setTimeZone(targetTimeZone);

    return targetCalendar.getTime();
}