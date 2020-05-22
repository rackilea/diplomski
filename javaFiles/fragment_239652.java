public String toString() {
    // "EEE MMM dd HH:mm:ss zzz yyyy";
    BaseCalendar.Date date = normalize();
    StringBuilder sb = new StringBuilder(28);
    int index = date.getDayOfWeek();
    if (index == BaseCalendar.SUNDAY) {
        index = 8;
    }
    convertToAbbr(sb, wtb[index]).append(' ');                        // EEE
    convertToAbbr(sb, wtb[date.getMonth() - 1 + 2 + 7]).append(' ');  // MMM
    CalendarUtils.sprintf0d(sb, date.getDayOfMonth(), 2).append(' '); // dd

    CalendarUtils.sprintf0d(sb, date.getHours(), 2).append(':');   // HH
    CalendarUtils.sprintf0d(sb, date.getMinutes(), 2).append(':'); // mm
    CalendarUtils.sprintf0d(sb, date.getSeconds(), 2).append(' '); // ss
    TimeZone zi = date.getZone();
    if (zi != null) {
        sb.append(zi.getDisplayName(date.isDaylightTime(), TimeZone.SHORT, Locale.US)); // zzz
    } else {
        sb.append("GMT");
    }
    sb.append(' ').append(date.getYear());  // yyyy
    return sb.toString();
}

[...]

private final static String wtb[] = {
    "am", "pm",
    "monday", "tuesday", "wednesday", "thursday", "friday",
    "saturday", "sunday",
    "january", "february", "march", "april", "may", "june",
    "july", "august", "september", "october", "november", "december",
    "gmt", "ut", "utc", "est", "edt", "cst", "cdt",
    "mst", "mdt", "pst", "pdt"