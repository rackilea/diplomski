long years = 1000;
LocalDate today = LocalDate.now();
LocalDate lastDate = today.plusYears( years );
int initialCapacity = ( int ) ( ( years + 1 ) * 366 );
List < LocalDate > dates = new ArrayList <>( initialCapacity );
LocalDate localDate = today;
System.out.println( "From: " + today + " to: " + lastDate );
while ( localDate.isBefore( lastDate ) ) {
    dates.add( localDate );
    // Setup next loop.
    localDate = localDate.plusDays( 1 );
}