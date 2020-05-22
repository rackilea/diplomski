Date date = new Date();
ZonedDateTime utc = date.toInstant().atZone(ZoneOffset.UTC);
ZonedDateTime paris = utc.withZoneSameInstant(ZoneId.of("Europe/Paris"));
System.out.println(utc);
System.out.println(paris);
System.out.println(paris.toLocalDateTime());