offset = ZoneOffset.ofHours(-1);
zoneId = ZoneId.ofOffset("UTC", offset);
timeStampformater = DateTimeFormatter.ofPattern("yyyy.MM.dd.hh.mm.ss");
System.out.println(LocalDateTime.now(zoneId).format(timeStampformater));

offset = ZoneOffset.ofHours(0);
zoneId = ZoneId.ofOffset("UTC", offset);
timeStampformater = DateTimeFormatter.ofPattern("yyyy.MM.dd.hh.mm.ss");
System.out.println(LocalDateTime.now(zoneId).format(timeStampformater));

offset = ZoneOffset.ofHours(1);
zoneId = ZoneId.ofOffset("UTC", offset);
timeStampformater = DateTimeFormatter.ofPattern("yyyy.MM.dd.hh.mm.ss");
System.out.println(LocalDateTime.now(zoneId).format(timeStampformater));