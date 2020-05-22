// define formatter once to be re-used wherever needed
DateTimeFormatter formatter = new DateTimeFormatterBuilder()
        .appendPattern("yyyy-MM-dd'T'HH:mm:ss") // all fields up seconds
        .appendFraction(ChronoField.NANO_OF_SECOND, 0, 9, true) // handle variable-length fraction of seconds
        .toFormatter();

String text = "2019-01-08T13:17:53.4225514";

LocalDateTime localTime = LocalDateTime.parse(text, formatter); // parse string as a zone-agnostic LocalDateTime object
ZonedDateTime utcTime = localTime.atZone(ZoneId.of("UTC")); // make it zoned as UTC zoned
ZonedDateTime cstTime = utcTime.withZoneSameInstant(ZoneId.of("America/Chicago")); // convert that date to the same time in CST

// print resulting objects
System.out.println(utcTime);
System.out.println(cstTime);