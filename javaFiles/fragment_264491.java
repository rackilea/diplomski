DateTimeFormatter fmt = new DateTimeFormatterBuilder()
        .appendValue(ChronoField.YEAR)
        .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
        .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
        .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
        .toFormatter()
        .withZone(ZoneOffset.UTC);

ZonedDateTime zonedDateTime = ZonedDateTime.parse("2008", fmt);