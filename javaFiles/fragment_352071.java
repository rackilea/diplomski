CsvParserSettings parserSettings = new CsvParserSettings();
settings.detectFormatAutomatically(); //detects the format 

//extracts the headers from the input
settings.setHeaderExtractionEnabled(true);

//or give the header names yourself
// if you use this it will override the headers read from the input (enabled above).
settings.setHeaders("A", "B", "C");

//now for the column selection
settings.selectFields("A", "C"); //rows will contain only values of column "A" and "C"
//or
settings.selectIndexes(0, 2); //rows will contain only values of columns at position 0 and 2

List<String[]> rows = new CsvParser(settings).parseAll(new File("/path/to/your.csv"), "UTF-8");