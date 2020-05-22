public static Date create(int year, int month, int day, int hour, int minute, int second) {
    return new Date(getTimeInMillis(year, month, day, hour, minute, second));
}

public static long getTimeInMillis(int year, int month, int day, int hour, int minute, int second, int milliseconds) {
    Calendar cal = Calendar.getInstance();

    cal.clear();
    cal.set(year, month, day, hour, minute, second);
    cal.set(Calendar.MILLISECOND, milliseconds);

    return cal.getTimeInMillis();
}