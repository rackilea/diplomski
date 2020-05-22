DateTimeFormatter formatter = new DateTimeFormatterBuilder()
    // append week year
    .appendValue(WeekFields.ISO.weekBasedYear(), 4)
    // separator
    .appendLiteral('-')
    // append week of week year field
    .appendValue(WeekFields.ISO.weekOfWeekBasedYear(), 2)
    // create formatter
    .toFormatter().withZone(ZoneOffset.UTC);