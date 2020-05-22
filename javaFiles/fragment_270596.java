String input = "Nov 30, 2013 19:00:00.001930000 CST";  
String basePattern = "MMM dd, yyyy HH:mm:ss";
DateTimeFormatter f = new DateTimeFormatterBuilder( )
        .appendPattern( basePattern )
        .appendFraction( ChronoField.NANO_OF_SECOND , 0 , 9 , true )
        .appendPattern( " " )
        .appendZoneText( TextStyle.SHORT  )
        .toFormatter( );

ZonedDateTime zdt = ZonedDateTime.parse( input , f );

System.out.println( "input: " + input );
System.out.println( "zdt.toString(): " + zdt );