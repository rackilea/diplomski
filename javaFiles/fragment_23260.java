private static List<Object[]> processMasterFile(final Map<String, String[]> mapOfDailyRecords) {
    //we'll put the updated data here
    final List<Object[]> output = new ArrayList<Object[]>();

    //configures the parser to process only the columns you are interested in.
    CsvParserSettings settings = new CsvParserSettings();
    settings.setHeaderExtractionEnabled(true);
    settings.selectFields("id", "company", "exp", "salary");

    //All parsed rows will be submitted to the following RowProcessor. This way the bigger Master file won't
    //have all its rows stored in memory.
    settings.setRowProcessor(new AbstractRowProcessor() {
        @Override
        public void rowProcessed(String[] row, ParsingContext context) {
            // Incoming rows from MASTER will have the ID as index 0.
            // If the daily update map contains the ID, we'll get the daily row
            String[] dailyData = mapOfDailyRecords.get(row[0]);
            if (dailyData != null) {
                //We got a match. Let's join the data from the daily row with the master row.
                Object[] mergedRow = new Object[8];

                for (int i = 0; i < dailyData.length; i++) {
                    mergedRow[i] = dailyData[i];
                }
                for (int i = 1; i < row.length; i++) { //starts from 1 to skip the ID at index 0
                    mergedRow[i + dailyData.length - 1] = row[i];
                }
                output.add(mergedRow);
            }
        }
    });

    CsvParser parser = new CsvParser(settings);
    //the parse() method will submit all rows to the RowProcessor defined above.
    parser.parse(newReader("/path/to/master.csv"));

    return output;
}