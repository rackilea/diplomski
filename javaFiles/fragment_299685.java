public void testFormatDateString() throws ParseException {

    String dateString = new java.util.Date().toString();

    System.out.println(dateString);

    // Force to Locale.US as this is hardcoded in Date#toString
    SimpleDateFormat format = new SimpleDateFormat(
            "EEE MMM dd HH:mm:ss z yyyy", Locale.US);

    Date date = format.parse(dateString);

    System.out.println(date.toString());
}