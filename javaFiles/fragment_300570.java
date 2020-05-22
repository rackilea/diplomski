LocalDateTime ldt = LocalDateTime.parse(valueIn, DateTimeFormatter.ofPattern(formatIn));
System.out.println("< " + ldt);

ZonedDateTime here = ldt.atZone(ZoneId.systemDefault());
System.out.println("here " + here);

ZonedDateTime there = here.withZoneSameInstant(ZoneId.of("GMT"));
System.out.println("there " + there);
String out = DateTimeFormatter.ofPattern(formatOut).format(there);
System.out.println("> " + out);