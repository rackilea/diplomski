// use system default timezone
ZoneId zone = ZoneId.systemDefault();
ZonedDateTime start = Instant.ofEpochMilli(1499628963860L).atZone(zone);
ZonedDateTime end = Instant.ofEpochMilli(1511809983860L).atZone(zone);

DateTimeFormatter fmt = DateTimeFormatter.ofPattern("EEE dd/MM HH:mm", new Locale("da", "DK"));
System.out.println(start.format(fmt));
System.out.println(end.format(fmt));