long start = System.nanoTime();

for ( LocalDate date : dates ) {
    String output = date.toString(); // Generate text in standard ISO 8601 format.
}

long stop = System.nanoTime();
long elapsed = ( stop - start );
long nanosEach = elapsed / dates.size();

System.out.println( "nanosEach: " + nanosEach );