public static void main(String... args){
    //First we parse the daily update file.
    CsvParserSettings settings = new CsvParserSettings();
    //here we tell the parser to read the CSV headers
    settings.setHeaderExtractionEnabled(true);
    //and to select ONLY the following columns.
    //This ensures rows with a fixed size will be returned in case some records come with less or more columns than anticipated.
    settings.selectFields("id", "name", "city", "zip", "occupation");

    CsvParser parser = new CsvParser(settings);

    //Here we parse all data into a list.
    List<String[]> dailyRecords = parser.parseAll(newReader("/path/to/daily.csv"));
    //And convert them to a map. ID's are the keys.
    Map<String, String[]> mapOfDailyRecords = toMap(dailyRecords);
    ... //we'll get back here in a second.