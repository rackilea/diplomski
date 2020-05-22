Instant firstInstant = null; // Track the baseline against which we calculate the increasing time
for ( CSVRecord record : records ) {
    String dateInput = record.get ( 0 );  // Zero-based index.
    String timeInput = record.get ( 1 );
    String priceInput = record.get ( 2 );
    //System.out.println ( dateInput + " | " + timeInput + " | " + priceInput );  // Dump input strings for debugging.