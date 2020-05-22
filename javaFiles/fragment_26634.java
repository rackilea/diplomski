DateTimeFormatter fmt = new DateTimeFormatterBuilder()
    // date and offset
    .append(DateTimeFormatter.ISO_OFFSET_DATE)
    // default values for hour and minute
    .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
    .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
    .toFormatter();
ZonedDateTime parsed = ZonedDateTime.parse("2018-04-19+02:00", fmt); // 2018-04-19T00:00+02:00