private static Date parseDate(String text)
    throws ParseException
{
    SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a MM/dd/yyyy",
                                                       Locale.US);      
    dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    return dateFormat.parse(text);
}