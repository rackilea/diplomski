public void showUTCTime(long millis, final String msg) {
    Calendar cal = Calendar.getInstance();
    cal.setTimeInMillis(0);
    DateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
    dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    System.out.println(msg + "(UTC):" + dateFormat.format(cal.getTime()));
}