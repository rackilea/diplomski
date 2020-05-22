DateTimeFormatter formatter = new DateTimeFormatterBuilder()
    // date/time
    .appendPattern("yyyy-MM-dd HH:mm:ss")
    // optional fraction of seconds (from 0 to 9 digits)
    .optionalStart().appendFraction(ChronoField.NANO_OF_SECOND, 0, 9, true).optionalEnd()
    // offset
    .appendPattern("x")
    // create formatter
    .toFormatter();