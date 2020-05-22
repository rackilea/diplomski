String dateString = "07/21-04:00:14.766098";

    String[] parts = dateString.split( "\\." );

    Calendar c = Calendar.getInstance();
    c.setTime( ( new SimpleDateFormat( "M/d-H:m:s" ) ).parse( parts[0] ) );
    c.set( Calendar.YEAR, 2014 );

    java.sql.Timestamp timestamp = new java.sql.Timestamp( c.getTimeInMillis() );

    if( parts.length == 2 ) {
        // Your fractional part must be 9 numbers length with tailing zeros
        // I am not sure how to pad string with zeros at right 
        int nanos = Integer.parseInt( String.format( "%-9s", parts[1] ).replace( ' ', '0' ) );
        timestamp.setNanos( nanos );
    }

    System.out.println( "Date string: " + dateString );
    System.out.println( "Timestamp  : " + timestamp.toString() );