public static DateTime convertDate(String timestamp) {

  int stdYear = 1970; // example for new default year

  DateTimeFormatter formatter = 
    new DateTimeFormatterBuilder().append(null, parsers).toFormatter()
    .withDefaultYear(stdYear);

  return formatter.parseDateTime(timestamp);
}