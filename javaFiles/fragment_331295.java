DateTimeZone timeZone = DateTimeZone.forID( "Europe/Budapest" ); // Or, perhaps DateTimeZone.UTC

// Inputs
DateTime contractStart = new DateTime( 2014, 1, 2, 0, 0, 0, timeZone );
DateTime contractStop = new DateTime( 2014, 5, 6, 0, 0, 0, timeZone );
Interval contractInterval = new Interval( contractStart, contractStop );

// Target to test
DateTime targetStart = new DateTime( 2013, DateTimeConstants.DECEMBER, 1, 0, 0, 0, timeZone );
DateTime targetStop = targetStart.plusMonths( 4 );
Interval targetInterval = new Interval( targetStart, targetStop );

boolean targetContainsContract = targetInterval.contains( contractInterval );
boolean targetOverlapsContract = ( targetInterval.overlap( contractInterval ) != null );