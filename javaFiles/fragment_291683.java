// Parse HH:mm
DateTimeFormatter formatter1 = new DateTimeFormatterBuilder()
        .appendPattern("HH:mm") // other time fields default to 0, see "Resolving"
        .parseDefaulting(ChronoField.EPOCH_DAY, 0) // short for 1970-01-01
        .toFormatter();
LocalDateTime ldt1 = LocalDateTime.parse("12:34", formatter1);
System.out.println(ldt1); // Prints 1970-01-01T12:34

// Parse YYYY-mm
DateTimeFormatter formatter2 = new DateTimeFormatterBuilder()
        .appendPattern("uuuu-MM")
        .parseDefaulting(ChronoField.DAY_OF_MONTH, 1) // see resolveDate()
        .parseDefaulting(ChronoField.NANO_OF_DAY, 0) // short for 00:00:00.000000000
        .toFormatter();
LocalDateTime ldt2 = LocalDateTime.parse("2016-11", formatter2);
System.out.println(ldt2); // Prints 2016-11-01T00:00