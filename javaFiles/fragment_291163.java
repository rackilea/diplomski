public static DateTime newDateTime(int hours, int minutes, int seconds) {
    Calendar c = Calendar.getInstance();
    int day = c.get(Calendar.DAY_OF_MONTH);
    int month = c.get(Calendar.MONTH);
    int year = c.get(Calendar.YEAR);
    return new DateTime(hours,minutes,seconds,day,month,year);
}