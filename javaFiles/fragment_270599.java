Set < ZoneId > zones = new HashSet <>( );
zones.add( ZoneId.of( "America/Detroit" ) );
zones.add( ZoneId.of( "America/New_York" ) );
zones.add( ZoneId.of( "America/Nassau" ) );
zones.add( ZoneId.of( "America/Cancun" ) );

String input = "Nov 30, 2013 19:00:00.001930000 Eastern Standard Time";  
String basePattern = "MMM dd, yyyy HH:mm:ss";
DateTimeFormatter f = new DateTimeFormatterBuilder( )
        .appendPattern( basePattern )
        .appendFraction( ChronoField.NANO_OF_SECOND , 0 , 9 , true )
        .appendPattern( " " )
        .appendZoneText( TextStyle.FULL , zones )
        .toFormatter( );

ZonedDateTime zdt = ZonedDateTime.parse( input , f );

System.out.println( "input: " + input );
System.out.println( "zdt.toString(): " + zdt );