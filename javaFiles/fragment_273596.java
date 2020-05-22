LocalDate start = new LocalDate( 2011, 2, 3 );
LocalDate stop = new LocalDate( 2016, 4, 5 );
int yearStart = start.getYear();
int yearStop = stop.getYear();
int month = 11;
int day = 22;

for ( i = yearStart, i <= yearStop, i++ ) 
{
    LocalDate x = new LocalDate( i, month, day );
    boolean matchStart = ( x.isEqual( start ) || x.isAfter( start ) );
    boolean matchStop = x.isBefore( stop ); // Half-Open approach where beginning of range is inclusive while ending is exclusive.
    if ( matchStart && matchStop ) 
    {
        // Add to collection of LocalDate objects.
        // Later you can ask each LocalDate object for its day-of-week.
    {
}