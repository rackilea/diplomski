public static void main(String[] args) throws Exception {
    int year = 2012;
    int month = 2; // eg. for march
    int day = 31;
    int hrs = 0;
    int min = 18;
    Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Berlin")); // GMT+1
    cal.set(year, month, day, hrs, min);
    long time = cal.getTimeInMillis();
    System.out.println(time);
    cal.setTimeInMillis(time);
    final DateFormat sdf = SimpleDateFormat.getDateTimeInstance(SimpleDateFormat.FULL, SimpleDateFormat.FULL);
    System.out.println(sdf.format(cal.getTime()));
}