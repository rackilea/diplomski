File input = new File("/path/to/your.csv")

    CsvParserSettings parserSettings = new CsvParserSettings();
    //...configure the parser

    // You can also use TSV and Fixed-width routines
    CsvRoutines routines = new CsvRoutines(parserSettings); 
    for (Address address : routines.iterate(Address.class, input, "UTF-8")) {
        //process your bean
    }