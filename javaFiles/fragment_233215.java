public static Calendar getCalenderFromDatePicker(DatePicker dp) {
    int day = dp.getDayOfMonth();
    int month = dp.getMonth();
    int year = dp.getYear();

    Calendar calendar = Calendar.getInstance();
    calendar.set(year, month, day);
    return calendar;
}