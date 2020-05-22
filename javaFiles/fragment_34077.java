ZonedDateTime zdt = 
  ZonedDateTime.of(2015, 10, 18, 0, 30, 0, 0, 
    ZoneId.of("America/Sao_Paulo")); // switch to summer time
ZonedDateTime zdt1 = zdt.truncatedTo(ChronoUnit.DAYS);
ZonedDateTime zdt2 = zdt.toLocalDate().atStartOfDay(zdt.getZone());

System.out.println(zdt); // 2015-10-18T01:30-02:00[America/Sao_Paulo]
System.out.println(zdt1); // 2015-10-18T01:00-02:00[America/Sao_Paulo]
System.out.println(zdt2); // 2015-10-18T01:00-02:00[America/Sao_Paulo]