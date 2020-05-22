// Using Java 8 Time API with formatter applying time zone
Instant instant = Instant.ofEpochSecond((long) d, (long) d * 1000000000 % 1000000000);

DateTimeFormatter fmt = DateTimeFormatter.ofPattern("EEE MMM d yyyy HH:mm:ss 'GMT'xx (z)")
                                         .withZone(ZoneId.of("Europe/Paris"));
System.out.println(fmt.format(instant));