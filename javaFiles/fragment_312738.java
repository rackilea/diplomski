// Prepare a data context based on plain old Java objects
    List<TableDataProvider<?>> tableDataProviders = new ArrayList<TableDataProvider<?>>();
    SimpleTableDef tableDef1 = new SimpleTableDef("snippetTableName1", new String[] {"id", "name"});
    tableDataProviders.add(new ArrayTableDataProvider(tableDef1,
            new ArrayList<Object[]>()));
    PojoDataContext dataContext = new PojoDataContext("snippetSchemaName", tableDataProviders);

    // Add some rows
    dataContext.executeUpdate(new UpdateScript() {

        public void run(UpdateCallback callback) {
            callback.insertInto("snippetTableName1").value("id", "id1").value("name", "name1").execute();
            callback.insertInto("snippetTableName1").value("id", "id2").value("name", "name2").execute();
        }
    });

    // Prepare dynamic query
    String[] selectArray = new String[2];
    selectArray[0] = "id";
    selectArray[1] = "name";

    Map<String, Object> whereClauses = new HashMap<String, Object>();
    whereClauses.put("id", "id1");
    whereClauses.put("name", "name1");

    SatisfiedSelectBuilder<?> queryBuilder = dataContext.query().from("snippetTableName1").select(selectArray);
    SatisfiedWhereBuilder<?> whereBuilder = null;

    int i = 0;
    for (Map.Entry<String, Object> whereClause: whereClauses.entrySet()) {
        if (i == 0) {
            whereBuilder = queryBuilder.where(whereClause.getKey()).eq(whereClause.getValue());
        } else {
            whereBuilder = whereBuilder.and(whereClause.getKey()).eq(whereClause.getValue());
        }
        i++;
    }

    DataSet dataSet = whereBuilder.execute();

    while (dataSet.next()) {
        Row row = dataSet.getRow();
        System.out.println("Row: " + row);
    }