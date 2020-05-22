LocalTime start = logTimes.get( 0 ); // Get first item. Uses annoying zero-based index counting.
LocalTime previous = start ;
List<LocalTime> sublistTimes = logTimes.subList( 1 , logTimes.size() ) ;  // A view over the original list, not actually separate.
List<Duration> spans = new ArrayList<>();
Duration limit = Duration.ofMinutes( 30 );
for( LocalTime t : sublistTimes ) {
    Duration d = Duration.between( previous , t ) ;
    if( d.compareTo( limit ) > 0 ) {  // If over the limit…
        System.out.println( "From " + previous + " to " + t + " = " + d ) ;
        spans.add( d ) ; // Remember the delta from previous time-of-day to this time-of-day because it is over our threshold.
    }
    previous = t ;  // Setup the next loop.
}

String results = "Start: " + start + " Deltas over limit of " + limit + ": " + spans ;
System.out.println( results ) ;