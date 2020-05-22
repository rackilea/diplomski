String input = "20161012235959.0Z";
 DateTimeFormatter f = DateTimeFormatter
       .ofPattern ( "uuuuMMddHHmmss.SX" ) 
       .withLocale( Locale.FRANCE )
       .withZone( ZoneId.of("UTC"));
 OffsetDateTime odt = OffsetDateTime.parse ( input , f );
 Instant instant = odt.toInstant ();

 System.out.println(input);
 System.out.print(f.format(instant));