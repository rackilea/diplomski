ZoneId z = ZoneId.systemDefault() ;  // Or ZoneId.of( "Africa/Tunis" )
LocalDate today = LocalDate.now( z ) ;

LocalDate localDate = today.with( org.threeten.bp.temporal.TemporalAdjusters.previousOrSame( DayOfWeek.SUNDAY ) ) ;
List< LocalDate > dates = new ArrayList<>( 7 ) ;
for( int i = 0 ; i < 7 ; i ++ ) {
    localDate = localDate.plusDays( i ) ;
    dates.add( localDate ) ;
}