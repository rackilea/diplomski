public static String convertToNewFormat(String dateStr) throws ParseException {
    TimeZone utc = TimeZone.getTimeZone("UTC");
    SimpleDateFormat sourceFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    SimpleDateFormat destFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    sourceFormat.setTimeZone(utc);
    Date convertedDate = sourceFormat.parse(dateStr);
    return destFormat.format(convertedDate);
}