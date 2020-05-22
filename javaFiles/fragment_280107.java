// create array with all possible patterns
DateTimeParser[] parsers = {
    DateTimeFormat.forPattern("EEE, dd MMM yyyy HH:mm:ss Z").getParser(),
    DateTimeFormat.forPattern("EEE, dd MMM yyyy HH:mm:ss ZZZ").getParser()
};

// create a formatter using the parsers array
DateTimeFormatter formatter = new DateTimeFormatterBuilder()
    .append(null, parsers) // use parsers array
    .toFormatter().withLocale(Locale.ENGLISH).withOffsetParsed();