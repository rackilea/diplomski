SuperColumnQuery<String, String, String, String> superColumnQuery = 
    HFactory.createSuperColumnQuery(ksp);
    superColumnQuery.setColumnFamily("Standard1").setKey("jsmith").setSuperName("first");
    QueryResult<HSuperColumn<String, String, String>> queryResult = superColumnQuery.execute();

    if (queryResult != null && queryResult.get() != null) {
        List<HColumn<String, String>> resultCols = queryResult.get().getColumns();
        for (HColumn<String, String> col : resultCols) {
            doSomething(col.getValue());
        }
    }