final Operation sql =
         sequenceOf(
                 CommonOperations.DELETE_ALL,
                 CommonOperations.INSERT_REFERENCE_DATA,
                 prepareSpecialData()
         );
 DbSetup dbSetup = new DbSetup(new DataSourceDestination(dataSource), sql);