ColumnProcessor columnProcessor = new ColumnProcessor();
settings.setProcessor(columnProcessor);
CsvParser parser = new CsvParser(settings);
parser.parse(new File("/path/to/your.csv), "UTF-8"); //all rows are submitted to the processor created above.

Map<String, List<String>> columnValues = columnProcessor.getColumnValuesAsMapOfNames();