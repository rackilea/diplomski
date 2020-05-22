DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();
builder.appendPattern(DATE_TIME_FORMAT_PATTERN);

ZonedDateTime defaults = ZonedDateTime.now();

builder.parseDefaulting(ChronoField.YEAR,
       defaults.getLong(ChronoField.YEAR));
builder.parseDefaulting(ChronoField.MONTH_OF_YEAR,
       defaults.getLong(ChronoField.MONTH_OF_YEAR));
builder.parseDefaulting(ChronoField.DAY_OF_MONTH,
       defaults.getLong(ChronoField.DAY_OF_MONTH));
// etc.

DateTimeFormatter formatter = builder.toFormatter();

ZonedDateTime returnable = ZonedDateTime.parse(dateTimeString, formatter);