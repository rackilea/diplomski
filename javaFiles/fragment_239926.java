public static long normalizeDate(long startDate) {
    // normalize the start date to the beginning of the (UTC) day
    Time time = new Time();
    time.set(1464181063013);
    int julianDay = Time.getJulianDay(1464181063013, time.gmtoff);
    return time.setJulianDay(julianDay);
}