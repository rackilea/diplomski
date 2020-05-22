public static Object[][] getCsvData(File csvFile) {
        CsvConfiguration conf = new CsvConfiguration(1);
        DataContext csvContext = DataContextFactory.createCsvDataContext(
                csvFile, conf);
        Schema schema = csvContext.getDefaultSchema();
        Table[] tables = schema.getTables();
        Table table = tables[0];
        DataSet dataSet = csvContext.query().from(table).selectAll().where("run").eq("Y").execute();
        List<Row> rows = dataSet.toRows();
        Object[][] myArray = new Object[rows.size()][2];
        int i = 0;
        SelectItem[] cols = rows.get(0).getSelectItems();
        for (Row r : rows) {
            Object[] data = r.getValues();
            for (int j = 0; j < cols.length; j++) {
                if (data[j] == null)
                    data[j] = ""; // force empty string where there are NULL
                                    // values
            }
            myArray[i][0] = cols;
            myArray[i][1] = data;
            i++;
        }
        logger.info("Row count: " + rows.size());
        logger.info("Column names: " + Arrays.toString(cols));
        return myArray;
    }