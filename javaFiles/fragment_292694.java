DateTimeFormatter formatter = new DateTimeFormatterBuilder()
    // date / time
    .appendPattern("yyyy-MM-dd HH:mm:ss")
    // nanoseconds, with minimum 1 and maximum 9 digits and a decimal point
    .appendFraction(ChronoField.NANO_OF_SECOND, 1, 9, true)
    // create formatter
    .toFormatter();
LocalDateTime datetime = LocalDateTime.parse(timeStamp, formatter);