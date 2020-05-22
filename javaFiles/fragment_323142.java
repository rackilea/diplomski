private static Date combine(Date date, Date time) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(time);
    int hour = cal.get(Calendar.HOUR_OF_DAY);
    int min = cal.get(Calendar.MINUTE);
    cal.setTime(date);
    cal.set(Calendar.HOUR_OF_DAY, hour);
    cal.set(Calendar.MINUTE, min);
    return cal.getTime();
}