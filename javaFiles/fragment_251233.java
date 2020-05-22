ArrayList fkIndex = new ArrayList();

    for (int i = 0; i <= fkSize - 1; i++){
    fkIndex.add(databaseConnection.getColumnNames(tableName).indexOf(databaseConnection.getFKeyData(tableName, 8).get(i)));
    }

    if (databaseConnection.getColumnNames(tableName).indexOf(
            databaseConnection.getPKey(tableName)) != 1) {
        if (fkIndex.contains(1) == false) {
            if (databaseConnection.getColCount(tableName) >= 1) {
                model.addColumn(columnNamesV.get(1), cellData1);
            }
        }
    }