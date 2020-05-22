CsvMapper csvMapper = new CsvMapper();
CsvSchema csvSchema = csvMapper.typedSchemaFor(Map.class).withHeader();

MappingIterator<Map<String, String>> it = csvMapper.readerFor(Map.class)
        .with(csvSchema.withColumnSeparator(','))
        .readValues(csvFile);

System.out.println("Column names: " + it.next().keySet());