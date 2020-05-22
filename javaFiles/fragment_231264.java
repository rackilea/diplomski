DateTimeFormatter simpleFormat = new DateTimeFormatterBuilder().
    parseCaseInsensitive().
    appendPattern("h[:mm]a").
    parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0).
    parseDefaulting(ChronoField.AMPM_OF_DAY, 0).
    toFormatter();

System.err.println(simpleFormat.parse("09AM", LocalTime::from));
System.err.println(simpleFormat.parse("09:12AM", LocalTime::from));
System.err.println(simpleFormat.parse("9AM", LocalTime::from));