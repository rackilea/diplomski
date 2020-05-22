public static DateTimeFormatter dateOptionalTimeParser() {
    if (dotp == null) {
        DateTimeParser timeOrOffset = new DateTimeFormatterBuilder()
            .appendLiteral('T')
            .appendOptional(timeElementParser().getParser())
            .appendOptional(offsetElement().getParser())
            .toParser();
        dotp = new DateTimeFormatterBuilder()
            .append(dateElementParser())
            .appendOptional(timeOrOffset)
            .toFormatter();
    }
    return dotp;
}