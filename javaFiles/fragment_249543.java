Iterable<CSVRecord> records;
try {
    records = CSVFormat.DEFAULT.parse ( in );  // 'records' is a CSVParser.
} catch ( IOException ex ) {
    // FIXME: Handle exception.
    System.out.println ( "[ERROR] " + ex );
    return; // Bail-out.
}