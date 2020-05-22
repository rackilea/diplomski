for ( final Locale locale : new Locale[] { Locale.US , Locale.CANADA_FRENCH , Locale.ITALY , Locale.KOREA } ) {
    final String inputShort = ( DayOfWeek.MONDAY.getDisplayName ( TextStyle.SHORT, locale ) );
    final String inputFull = ( DayOfWeek.MONDAY.getDisplayName ( TextStyle.FULL, locale ) );

    final DateTimeFormatter dtf = new DateTimeFormatterBuilder ( )
            .appendOptional ( DateTimeFormatter.ofPattern ( "EEEE" ) )
            .appendOptional ( DateTimeFormatter.ofPattern ( "E" ) )
            .toFormatter ( locale );

    final DayOfWeek dow1 = DayOfWeek.from ( dtf.parse ( inputShort ) ); 
    final DayOfWeek dow2 = DayOfWeek.from ( dtf.parse ( inputFull ) ); 

    System.out.println ( "" );
    System.out.println ( "Language: " + locale.getDisplayLanguage ( Locale.US ) );
    System.out.println ( "inputShort: " + inputShort + " | dow1: " + dow1 );
    System.out.println ( "inputFull: " + inputFull + " | dow2: " + dow2 );
}