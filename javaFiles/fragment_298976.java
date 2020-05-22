private static boolean isTimeInRange(long currentMillis, long fromMillis, long toMillis) {
    Calendar cal = Calendar.getInstance();
    cal.setTimeInMillis(currentMillis);
    int currentMinuteOfDay = cal.get(Calendar.HOUR_OF_DAY) * 60 + cal.get(Calendar.MINUTE);
    cal.setTimeInMillis(fromMillis);
    int fromMinuteOfDay = cal.get(Calendar.HOUR_OF_DAY) * 60 + cal.get(Calendar.MINUTE);
    cal.setTimeInMillis(toMillis);
    int toMinuteOfDay = cal.get(Calendar.HOUR_OF_DAY) * 60 + cal.get(Calendar.MINUTE);
    if (fromMinuteOfDay <= toMinuteOfDay)
        return (currentMinuteOfDay >= fromMinuteOfDay && currentMinuteOfDay < toMinuteOfDay);
    return (currentMinuteOfDay >= fromMinuteOfDay || currentMinuteOfDay < toMinuteOfDay);
}