/**
 * Converts a DateTime to a string using the given pattern (format)
 * @param dateTime
 * @param pattern
 * @return
 */
public static String convertDateTimeToPattern(DateTime dateTime,String pattern){
    DateTimeFormatter fmt = DateTimeFormat.forPattern(pattern);
    return dateTime.toString(fmt);
}