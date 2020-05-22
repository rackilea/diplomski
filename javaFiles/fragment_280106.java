// create parser for "GMT"
DateTimeParser gmtParser = DateTimeFormat.forPattern("ZZZ").getParser();

// create parser for "+0200"
DateTimeParser offsetParser = DateTimeFormat.forPattern("Z").getParser();

DateTimeFormatter formatter = new DateTimeFormatterBuilder()
    .appendPattern("EEE, dd MMM yyyy HH:mm:ss ") // common pattern
    .appendOptional(gmtParser)    // optional parser for GMT
    .appendOptional(offsetParser) // optional parser for +0200
    .toFormatter().withLocale(Locale.ENGLISH).withOffsetParsed();