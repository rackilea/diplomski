DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE, dd MMMM yyyy HH:mm:ss z", Locale.ENGLISH);
LocalDateTime ldt = LocalDateTime.parse("Mon, 14 May 2018 11:47:11 GMT", formatter);
System.out.println(ldt);
ZoneId zoneID = ZoneId.of("GMT");
ZonedDateTime zdt = ldt.atZone(zoneID);
System.out.println(zdt.format(formatter));