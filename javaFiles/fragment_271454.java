DateTimeParser[] parsers = { 
  new DateTimeFormatterBuilder()
    .appendLiteral('.')
    .appendFractionOfSecond(2, 3) // or even set min-digits to 1
    .appendTimeZoneOffset("Z", true, 1, 2)
    .toParser(),
  new DateTimeFormatterBuilder()
    .appendTimeZoneOffset("Z", true, 1, 2)
    .toParser()};
DateTimeFormatter dtf =
  new DateTimeFormatterBuilder()
    .appendPattern("yyyy-MM-dd'T'HH:mm:ss")
    .append(null, parsers)
    .toFormatter();
String input = "2014-08-02T22:21:32.123Z";
System.out.println(dtf.parseDateTime(input));
// in my timezone: 2014-08-03T00:21:32.123+02:00

input = "2014-08-02T22:21:32.12Z";
System.out.println(dtf.parseDateTime(input));
// 2014-08-03T00:21:32.120+02:00

input = "2014-08-02T22:21:32Z";
System.out.println(dtf.parseDateTime(input));
// 2014-08-03T00:21:32.000+02:00