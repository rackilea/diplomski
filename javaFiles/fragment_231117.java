LocalDateTime date2=LocalDateTime.now(ZoneId.of("America/New_York"));
System.out.println("date now:"+date2);
String format2=ZonedDateTime.now().format(DateTimeFormatter.ofPattern("dd/MMM/yyyy HH:mm:ss"));
System.out.println(format2);
//=date.format(DateTimeFormatter.ofPattern("dd/MMM/yyyy'T'hh:mm:ss.SX Z"));
LocalDateTime date3=LocalDateTime.parse(format2,
                DateTimeFormatter.ofPattern("dd/MMM/yyyy HH:mm:ss").withLocale(Locale.ENGLISH));

System.out.println("dsate now:"+date3);