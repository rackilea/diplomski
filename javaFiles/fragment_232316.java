public String formatInTimezone(String utcDateString, String intendedTimeZone) {
    SimpleDateFormat utcFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
    utcFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    Date theDate = utcFormat.parse(utcDateString);

    SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss z");
    outputFormat.setTimeZone(TimeZone.getTimeZone(intendedTimeZone));
    return outputFormat.format(theDate);
}