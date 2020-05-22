//initialize an arraylist with a good size to avoid reallocation
    final ArrayList<Film> films = new ArrayList<Film>(20000);
    CsvParserSettings parserSettings = new CsvParserSettings();
    parserSettings.setLineSeparatorDetectionEnabled(true);
    parserSettings.setHeaderExtractionEnabled(true);

    //don't generate strings for columns you don't want
    parserSettings.selectIndexes(7, 8, 9, 14, 22, 23);

    //keep generating rows with the same number of columns found in the input
    //indexes not selected will have nulls as they are not processed.
    parserSettings.setColumnReorderingEnabled(false); 

    parserSettings.setProcessor(new AbstractRowProcessor(){
        @Override
        public void rowProcessed(String[] row, ParsingContext context) {
            if(row.length == 24 && "en".equals(row[7]) && row[14] != null){
                films.add(new Film(row[8], row[9], row[14], row[22], row[23], row[7]));
            }
        }
    });

    CsvParser parser = new CsvParser(parserSettings);
    long start = System.currentTimeMillis();
    try {
        parser.parse(new File(FILENAME), "UTF-8"); 
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }

    System.out.printf(MessageFormat.format("Time: {0}",(System.currentTimeMillis()-start)));
    return films.toArray(new Film[0]);