public void testParseDate() throws Exception {

    TimeZone UTC = TimeZone.getTimeZone("UTC");

    // Create a UTC formatter
    final SimpleDateFormat formatter = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm:ss z");
    formatter.setTimeZone(UTC);

    // Create a UTC Gregorian Calendar (stores internally in UTC, so
    // get(Calendar.HOUR_OF_DAY) returns in UTC instead of in the
    // local machine's timezone.
    final Calendar c = new GregorianCalendar(UTC);

    // Ask the formatter for a date representation and pass that
    // into the GregorianCalendar (which will convert it into
    // it's internal timezone, which is also UTC.
    c.setTime(formatter.parse("2013-03-02 11:59:59 UTC"));

    // Output the UTC hour of day
    assertEquals(11, c.get(Calendar.HOUR_OF_DAY));
}