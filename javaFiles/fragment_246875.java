public static String getStringDateFormTimeStamp(long timestamp) {
    try {
        Calendar calendar = Calendar.getInstance();
        TimeZone tz = TimeZone.getDefault();
        calendar.setTimeInMillis(timestamp);
        calendar.add(Calendar.MILLISECOND, tz.getOffset(calendar.getTimeInMillis()));
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        Date currenTimeZone = calendar.getTime();
        return sdf.format(currenTimeZone);
    } catch (Exception e) {
        Timber.d(e);
    }
    return "";
}


 public static long StringDateToTimeStamp(String string_date){
    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
    Date d = null;
    try {
        d = f.parse(string_date);
        calendar.setTime(d);
    } catch (ParseException e) {
        e.printStackTrace();
    }

    return calendar.getTimeInMillis();

}