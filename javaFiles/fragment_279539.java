// convert millis value to a timezone
Instant instant = Instant.ofEpochMilli(1508206600485L);
ZonedDateTime z = instant.atZone(ZoneId.of("Australia/Sydney"));
// format it
DateTimeFormatter fmt = DateTimeFormatter.ofPattern("hh:mm dd/MM/yyyy");
System.out.println(fmt.format(z)); // 01:16 17/10/2017