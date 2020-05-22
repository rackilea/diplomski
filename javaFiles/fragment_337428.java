public static void main(String ... args){
    CsvWriterSettings writerSettings = new CsvWriterSettings();

    ObjectRowWriterProcessor writerProcessor = new ObjectRowWriterProcessor(); // handles rows of objects and conversions to String.
    writerProcessor.convertAll(Conversions.toBoolean("T", "F")); // will write "T" and "F" instead of "true" and "false"

    writerSettings.setRowWriterProcessor(writerProcessor);

    CsvWriter writer = new CsvWriter(writerSettings);
    writerSettings.setHeaders("A", "B", "C", "D");

    String line1 = writer.processRecordToString(true, false, false, true);
    String line2 = writer.processRecordToString(false, false, true, true);

    System.out.println("### Rows written ###");

    System.out.println(line1);
    System.out.println(line2);

    // Now, let's read these lines

    CsvParserSettings parserSettings = new CsvParserSettings();

    ObjectRowListProcessor readerProcessor = new ObjectRowListProcessor(); // handles conversions from String to Objects and adds the result to a list
    readerProcessor.convertAll(Conversions.toBoolean("T", "F")); //reads "T" and "F" back to true and false

    parserSettings.setRowProcessor(readerProcessor);

    CsvParser parser =  new CsvParser(parserSettings);
    parser.parseLine(line1); //handled by the readerProcessor
    parser.parseLine(line2); //handled by the readerProcessor

    System.out.println("### Rows parsed ###");

    List<Object[]> rows = readerProcessor.getRows();
    for(Object[] row : rows){
        System.out.println(Arrays.toString(row));
    }
}