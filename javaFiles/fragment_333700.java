DateTimeParser dtp = new DateTimeFormatterBuilder()
    .appendYear(4,4)
    .appendLiteral("-")
    .appendDayOfMonth(2)
    .appendLiteral("-")
    .appendMonthOfYear(2)
    .append(new JodaDateTimeConsumeAll())
    .toFormatter()
    .getParser();