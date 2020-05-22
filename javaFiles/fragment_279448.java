Table RESOURCES = Database.open(new File("TargetFile.mdb")).getTable("RESOURCES");
    int pcount = RESOURCES.getRowCount();

    String csvFilename = "C:\\STATS\\APEX\\report.csv";
    CSVReader csvReader = new CSVReader(new FileReader(csvFilename));
    List<String[]> content = csvReader.readAll();
    Map<ValueKey, Integer> csvValuesCount = new HashMap<ValueKey, Integer>();
    for (String[] rowcsv  : content) {
        ValueKey key = new ValueKey(rowcsv[6], rowcsv[1]);
        Integer count = csvValuesCount.get(key);
        csvValuesCount.put(key,count == null ? 1: count + 1);

    }

    int count = 0;
    // Taking 1st resource data
    for (int i = 0; i < pcount; i++) {
        Map<String, Object> row = RESOURCES.getNextRow();
        TEAM = row.get("TEAM").toString();
        MDMID = row.get("MDM ID").toString();
        NAME = row.get("RESOURCE NAME").toString();
        PGNAME = row.get("PG NAME").toString();
        PGTARGET = row.get("PG TARGET").toString();
        int PGTARGETI = Integer.parseInt(PGTARGET);
        Integer countInteger = csvValuesCount.get(new ValueKey(MDMID, PGNAME));
        count = countInteger == null ? 0: countInteger;
    }