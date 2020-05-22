String input1 = "out 29 23:00:00 GMT 2011";
String input2 = "out 30 23:00:00 GMT 2011";

Locale locale_pt_BR = new Locale.Builder().setLanguage( "pt" ).setRegion( "BR" ).build(); //
DateTimeFormatter formatter = DateTimeFormat.forPattern( "MMM dd HH:mm:ss 'GMT' yyyy" ).withLocale( locale_pt_BR ).withZone( DateTimeZone.UTC );

DateTime dateTime1 = null;
DateTime dateTime2 = null;
DateTime dateTime1_Sao_Paulo = null;
DateTime dateTime2_Sao_Paulo = null;
try {
    dateTime1 = formatter.parseDateTime( input1 );
    dateTime2 = formatter.parseDateTime( input2 );
    // Adjust to "America/Sao_Paulo" time zone.
    DateTimeZone zone_Sao_Paulo = DateTimeZone.forID( "America/Sao_Paulo" );
    dateTime1_Sao_Paulo = dateTime1.withZone( zone_Sao_Paulo );
    dateTime2_Sao_Paulo = dateTime2.withZone( zone_Sao_Paulo );
} catch ( IllegalArgumentException e ) {
    // … Handle exception.
    System.out.println( "ERROR - Unexpected input for parsing into a date-time object." );
}