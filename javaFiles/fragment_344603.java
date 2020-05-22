ColumnPositionMappingStrategy<Country> strat = new ColumnPositionMappingStrategy<Country>();
    strat.setType(Country.class);
    String[] columns = new String[] {"countryName", "capital"};
    strat.setColumnMapping(columns);

    PublicProcessLineCsvToBean<Country> csv = new PublicProcessLineCsvToBean<Country>();

    String csvFilename = "C:\\sample.csv";
    CSVReader csvReader = new CSVReader(new FileReader(csvFilename));
    List<Country> list = new ArrayList<Country>();

    String [] row = csvReader.readNext(); //skip header
    if(row == null) throw new RuntimeException("File is empty");
    row = csvReader.readNext();
    String [] nextRow = csvReader.readNext();
    while(row != null) {
        if(nextRow == null) break; //check what 'row' is last
        if("Total:".equalsIgnoreCase(row[1])) break; //check column for special strings

        list.add(csv.processLine(strat, row));

        row = nextRow;
        nextRow = csvReader.readNext();
    }