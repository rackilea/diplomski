static DateFormat _sdf = new SimpleDateFormat("hh:mm a");
static String minutesSinceMidnight(int minutes) {
    Calendar cal = Calendar.getInstance();
    cal.set(Calendar.AM_PM, Calendar.AM);
    cal.set(Calendar.HOUR, 0);
    cal.set(Calendar.MINUTE, 0);
    cal.set(Calendar.SECOND, 0);
    cal.set(Calendar.MILLISECOND, 0);
    cal.add(Calendar.MINUTE, minutes);
    return _sdf.format(cal.getTime());
}