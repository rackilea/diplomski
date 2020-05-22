public String getFromatDate(long dateTime) {
    String formatedDate;
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeInMillis(dateTime);
    Date mDate = calendar.getTime();
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm a", new Locale("en"));
    formatedDate = sdf.format(mDate);
    return formatedDate;
}