ZoneId z = ZoneId.of( "Africa/Tunis" ) ;
ZonedDateTime zdt = ZonedDateTime.now( z ) ;

System.out.println( zdt ) ;  // Generate text representing this value in standard ISO 8601 format.

Locale locale = new Locale( "ar" , "TN" ) ; // Arabic language, Tunisia cultural norms.
DateTimeFormatter f = DateTimeFormatter.ofLocalizedDateTime( FormatStyle.FULL ).withLocale( locale ) ;
String output = zdt.format( f ) ;  // Generate text describing this moment in a localized format.