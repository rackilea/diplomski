LocalTime lt = LocalTime.of( 17 , 0 );
DateTimeFormatter f = DateTimeFormatter.ofPattern( "hh:mm a" );
for ( Locale locale : Locale.getAvailableLocales() ) {
    String output = lt.format( f.withLocale( locale ) );
    System.out.println( locale.getDisplayName( Locale.US ) + " ➙ " + output );
}