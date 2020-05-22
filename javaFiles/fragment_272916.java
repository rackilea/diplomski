// use the Jackcess (2.1.5 or later) API directly 
//   to add a column to an existing table
//
// Note: Close any open UCanAccess connection first.
//
com.healthmarketscience.jackcess.Database db = 
        com.healthmarketscience.jackcess.DatabaseBuilder.open(new File(dbFileSpec));
new com.healthmarketscience.jackcess.ColumnBuilder("newCol")
        .setType(com.healthmarketscience.jackcess.DataType.LONG)
        .addToTable(db.getTable("TableName"));
db.close();