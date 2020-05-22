private String formatTime(String timestampFromApi){
    SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);
    df1.setTimeZone(TimeZone.getTimeZone("UTC"));
    Date date = df1.parse(timestampFromApi);

    Log.v(TAG, "In your timezone: " + df1.format(getAdjustedTime(date.getTime())));
}

private Date getAdjustedTime(long utcDate){
    return new Date(utcDate + TimeZone.getDefault().getOffset(new Date().getTime()));
}