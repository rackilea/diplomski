public static void main(String[] args) {
    String fmtString = "EEEE MMM d, yyyy 'at' h:mm a";
    // E - Day name in week 
    // M - Month in year
    // d - Day in month
    // y - Year
    // The constant String at
    // h - Hour in am/pm (1-12)
    // m - Minute in hour
    // a - Am/pm marker
    DateFormat sdf = new SimpleDateFormat(fmtString);
    try {
        Date d = sdf.parse("Monday Jan 10, 2015 at 5:15 PM");
        System.out.println(sdf.format(d));
    } catch (ParseException e) {
        e.printStackTrace();
    }
}