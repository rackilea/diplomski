for ( DayOfWeek dayOfWeek : daysOfWeek ) {
    List<LocalDate> dates = new ArrayList<> ( 5 );
    LocalDate ld = firstOfMonth.with ( TemporalAdjusters.dayOfWeekInMonth ( 1 , dayOfWeek ) );
    do {
        dates.add ( ld );
        // Set up next loop.
        ld = ld.plusWeeks ( 1 );
    } while ( YearMonth.from ( ld ).equals ( ym ) );  // While in the targeted month.
    System.out.println ( "ym.toString(): " + ym + " | dayOfWeek.toString(): " + dayOfWeek + " | dates: " + dates );
}