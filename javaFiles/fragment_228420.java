ICsvListReader listReader = null;
try {
    listReader = new CsvListReader(new FileReader(CSV_FILENAME),
        CsvPreference.STANDARD_PREFERENCE);

    listReader.getHeader(true); // skip the header

    final CellProcessor[] processors = 
            new CellProcessor[]{new Optional(), new ParseInt()};

    List<Object> row;
    while( (row = listReader.read(processors)) != null ) {
        System.out.println(String.format("lineNo=%s, rowNo=%s, row=%s",
            listReader.getLineNumber(), listReader.getRowNumber(), row));
    }

} catch (final SuperCsvException e){

    // here's what you're after!
    final CsvContext context = e.getContext();
    System.out.println(String.format(
        "something went wrong on lineNo=%s, rowNo=%s, colNo=%s",
        context.getLineNumber(), 
        context.getRowNumber(), 
        context.getColumnNumber()));

} finally {
    if( listReader != null ) {
        listReader.close();
    }
}