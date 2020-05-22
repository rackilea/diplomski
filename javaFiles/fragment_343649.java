public static String convertToTimeStamp(Date date, boolean showSeconds) {
    String pattern = "hh:mm:ss";
    if (!showSeconds) {
        pattern = "hh:mm";
    }
    DateFormat df = new SimpleDateFormat(pattern);
    return df.format(date);
}