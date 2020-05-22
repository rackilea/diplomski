ZonedDateTime zdt = 
  ZonedDateTime.of(
    2015, 1, 25, 23, 35, 7, 684000000, 
    ZoneId.of("Europe/London"));

System.out.println(zdt); // 2015-01-25T23:35:07.684Z[Europe/London]
System.out.println(zdt.getZone().getId()); // Europe/London
System.out.println(zdt.toInstant().toEpochMilli()); // 1422228907684

DateTimeZone london = DateTimeZone.forID(zdt.getZone().getId());
DateTime dt = new DateTime(zdt.toInstant().toEpochMilli(), london);
System.out.println(dt); // 2015-01-25T23:35:07.684Z