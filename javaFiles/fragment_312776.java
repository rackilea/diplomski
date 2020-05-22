Table tbl = db.getTable(tableName);
Row row = CursorBuilder.findRowByPrimaryKey(tbl, 3);  // i.e., ID = 3
if (row != null) {
    // Note: column names are case-sensitive
    row.put("Title", "The New Title For This Book");
    tbl.updateRow(row);
}