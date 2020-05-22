// Milliseconds parser
final DateTimeParser msParser = new DateTimeFormatterBuilder()
    .appendLiteral('.').appendDecimal(millisOfSecond(), 1, 3)
    .toParser();

DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();

builder = builder.appendFixedDecimal(year(), 4)
    .appendFixedDecimal(monthOfYear(), 2)
    .appendFixedDecimal(dayOfMonth(), 2)
    .appendLiteral('-')
    .appendFixedDecimal(hourOfDay(), 2)
    .appendLiteral(':')
    .appendFixedDecimal(minuteOfHour(), 2)
    .appendLiteral(':')
    .appendFixedDecimal(secondOfMinute(), 2)
    .appendOptional(msParser); // <-- HERE: optional milliseconds
// builder.build().withTimeZone(DateTimeZone.UTC) will return the formatter