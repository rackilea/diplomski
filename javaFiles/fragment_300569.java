String formatIn = "yyyy-MM-dd-HH.mm.ss.SSSSSS";
String formatOut = "yyyy-MM-dd'T'HH:mm:ss.SSSz";

String valueIn = "2016-01-19-09.55.00.000000";

LocalDateTime ldt = LocalDateTime.parse(valueIn, DateTimeFormatter.ofPattern(formatIn));
System.out.println("< " + ldt);

ZonedDateTime zdt = ZonedDateTime.of(ldt, ZoneId.systemDefault());        
String out = DateTimeFormatter.ofPattern(formatOut).format(zdt);
System.out.println("> " + out);