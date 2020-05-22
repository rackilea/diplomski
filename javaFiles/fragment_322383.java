ZoneId z = ZoneId.of( "America/Montreal" ) ;
// Better to specify time zone explicitly than rely on the default implicitly.
ZonedDateTime zdt = ZonedDateTime.now( z ) ;  
FormatStyle s = FormatStyle.LONG ; 
Locale l = Locale.CANADA_FRENCH ;
// Better to specify locale explicitly than rely on the default implicitly.
DateTimeFormatter f = DateTimeFormatter.ofLocalizedDateTime( s ).withLocale( l ) ; 
String output = zdt.format( f ) ;