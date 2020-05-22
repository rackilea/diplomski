DateTimeFormatter fmt = new DateTimeFormatterBuilder()
    // month-year
    .appendPattern("MM-yyyy")
    // default value for day
    .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
    // create formatter
    .toFormatter();
LocalDate dt = LocalDate.parse("09-2017", fmt);