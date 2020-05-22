CSVReader reader = new CSVReader(new FileReader("yourfile.csv"));

ColumnPositionMappingStrategy strat = new ColumnPositionMappingStrategy();
strat.setType(Person.class);

// the fields to bind do in your JavaBean
String[] columns = new String[] {"name", "age"}; 
strat.setColumnMapping(columns);

CsvToBean csv = new CsvToBean();
List list = csv.parse(strat, reader); // the people