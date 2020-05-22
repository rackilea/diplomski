public DateTime(int hours, int minutes, int seconds) {
    this(hours, minutes, seconds, Calendar.getInstance());
}
private DateTime(int hours, int minutes, int seconds, Calendar c) {
    this(hours,minutes,seconds,c.get(Calendar.DAY_OF_MONTH),c.get(Calendar.MONTH),c.get(Calendar.YEAR));
}