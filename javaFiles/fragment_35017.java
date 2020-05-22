int count = 5 ;
List<ZonedDateTime> datesA = new ArraySet<>( count );
for( int i = 1 , i <= count , i++ ) {
    datesA.add( zdt );
    // Prepare for next loop.
    zdt = zdt.plusDays( 1 );
}