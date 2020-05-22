public static boolean isValidDateFormat(String value, String... formats) 
{
    for(String format : formats) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = sdf.parse(value);
        if(value != null && value.equals(sdf.format(date)) ) {
            return true;
        }
    }
    return false;
}