CSVParser parser = new CSVParserBuilder()
        .withSeparator(';')
        .withIgnoreQuotations(true)
        .build();

CSVReader csvReader = new CSVReaderBuilder(reader)
        .withSkipLines(0)
        .withCSVParser(parser)
        .build();