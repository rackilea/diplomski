// offset parser (for "+0000")
DateTimeParser offsetParser = new DateTimeFormatterBuilder().appendPattern("Z").toParser();
// timezone name parser (for "EST")
DateTimeParser zoneNameParser = new DateTimeFormatterBuilder().appendPattern("z").toParser();
// formatter for both patterns
DateTimeFormatter fmt = new DateTimeFormatterBuilder()
    // append common pattern
    .appendPattern("EEE, d MMM yyyy HH:mm:ss ")
    // optional offset
    .appendOptional(offsetParser)
    // optional timezone name
    .appendOptional(zoneNameParser)
    // create formatter (use English Locale to make sure it parses weekdays and month names independent of JVM config)
    .toFormatter().withLocale(Locale.ENGLISH)
    // make sure the offset "+0000" is parsed
    .withOffsetParsed();

// parse the strings
DateTime est = fmt.parseDateTime("Sat, 10 Jun 2017 12:49:45 EST");
DateTime utc = fmt.parseDateTime("Sun, 11 Jun 2017 18:18:23 +0000");
System.out.println(est);
System.out.println(utc);