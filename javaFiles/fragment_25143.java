// Using Java 8 Time API with timezoned date value
ZonedDateTime dateTime = Instant.ofEpochSecond((long) d, (long) d * 1000000000 % 1000000000)
                                .atZone(ZoneId.of("Europe/Paris"));

DateTimeFormatter fmt = DateTimeFormatter.ofPattern("EEE MMM d yyyy HH:mm:ss 'GMT'xx (z)");
System.out.println(dateTime.format(fmt));