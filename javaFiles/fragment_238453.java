java.util.Locale.setDefault( new Locale.Builder().setLanguage( "pt" ).setRegion( "BR" ).build() );  // **HACK* Think twice before ever setting the default of your JVM’s locale or time zone. Generally a bad idea.
java.text.DateFormat dd = new java.text.SimpleDateFormat( "MMM dd HH:mm:ss zzz yyyy" );
dd.setTimeZone( java.util.TimeZone.getTimeZone( "GMT" ) );
Date parse = null;
Date parse2 = null;
try {
    parse = dd.parse( "Out 29 23:00:00 GMT 2011" );
    parse2 = dd.parse( "Out 30 23:00:00 GMT 2011" );
} catch ( ParseException ex ) {
    Logger.getLogger( JodaTimeWork.class.getName() ).log( Level.SEVERE , null , ex );
}
System.out.println( parse ); 
System.out.println( parse2 );