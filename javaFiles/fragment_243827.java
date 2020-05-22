public static Calendar getISOCalendar() {
    Calendar calendar = Calendar.getInstance();
    calendar.setMinimalDaysInFirstWeek(4);
    calendar.setFirstDayOfWeek(Calendar.MONDAY);
    return calendar;
}