public String GetLocalDateStringFromUTCString(String utcLongDateTime) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String localDateString = null;

    long when = 0;
    try {
        when = dateFormat.parse(utcLongDateTime).getTime();
    } catch (ParseException e) {
        e.printStackTrace();
    }
    localDateString = dateFormat.format(new Date(when + TimeZone.getDefault().getRawOffset() + (TimeZone.getDefault().inDaylightTime(new Date()) ? TimeZone.getDefault().getDSTSavings() : 0)));

    return localDateString;
}