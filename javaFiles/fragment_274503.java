new DateTimeFormatterBuilder()
    .append(DateTimeFormatter.BASIC_ISO_DATE)
    .appendLiteral('Z')
    .append(DateTimeFormatter.ISO_LOCAL_TIME)
    .toFormatter()
    .parse("20180302Z17:45:21");