private static String getDateUntil(int i, Calendar cal) {
    int month = 0 - i;
    Calendar mycal = (Calendar)cal.clone();  // Make a copy of the initial instance
    mycal.add(Calendar.MONTH, month);
    Date result = mycal.getTime();
    String dateUntil = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss").format(result);
    return dateUntil;
}