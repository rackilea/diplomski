if( recurrences.size > 0 ) { // If any recurrences to schedule…
    List<LocalDate> occurrences = new ArrayList<>();
    LocalDate ld = this.start ;
    while ( ld.isBefore( this.stop ) ) {
        for( DayOfWeek dow , this.recurrence ) {
            ld = ld.with( TemporalAdjusters.next( dow ) );
            occurrences.add( ld );
…