String newline = "\r\n";
StringBuilder input = new StringBuilder ();
input.append ( "2016-02-03,15:10:00,37" ).append ( newline );
input.append ( "2016-02-03,15:15:00,38" ).append ( newline );  // 5 minutes later.
input.append ( "2016-02-03,15:17:00,39" ).append ( newline );  // 2 minutes later.

Reader in = new StringReader ( input.toString () );