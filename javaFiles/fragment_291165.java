public DateTime(int hours, int minutes, int seconds) {
    Calendar c = Calendar.getInstance();
    int day = c.get(Calendar.DAY_OF_MONTH);
    int month = c.get(Calendar.MONTH);
    int year = c.get(Calendar.YEAR);
    set(hours,minutes,seconds,day,month,year);
}
public DateTime(int hours, int minutes, int seconds, int day, int month, int year) {
    set(hours,minutes,seconds,day,month,year);
}
private final void set(int hours, int minutes, int seconds, int day, int month, int year) { ... }