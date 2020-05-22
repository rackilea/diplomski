public static synchronized TimeZone getTimeZone(String ID) {
    return getTimeZone(ID, true);
}
...
private static TimeZone getTimeZone(String ID, boolean fallback) {
    TimeZone tz = ZoneInfo.getTimeZone(ID);
    if (tz == null) {
        tz = parseCustomTimeZone(ID);
        if (tz == null && fallback) {
            tz = new ZoneInfo(GMT_ID, 0);
        }
    }
    return tz;
}
...
private static final TimeZone parseCustomTimeZone(String id) {
    int length;

    // Error if the length of id isn't long enough or id doesn't
    // start with "GMT".
    if ((length = id.length()) < (GMT_ID_LENGTH + 2) ||
        id.indexOf(GMT_ID) != 0) {
        return null;
    }
    ...