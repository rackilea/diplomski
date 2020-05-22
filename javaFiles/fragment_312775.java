String dbFileSpec = "C:/Users/Public/JackcessTest.accdb";
String tableName = "Book";
try (Database db = new DatabaseBuilder()
        .setFile(new File(dbFileSpec))
        .setAutoSync(false)
        .open()) {

    // sample data (e.g., from parsing of an input line)
    String title = "So, Anyway";
    String author = "Cleese, John";

    Table tbl = db.getTable(tableName);
    Object[] rowData = tbl.addRow(Column.AUTO_NUMBER, title, author);
    int newId = (int)rowData[0];  // retrieve generated AutoNumber
    System.out.printf("row inserted with ID = %d%n", newId);

    // this is a try-with-resources block, 
    //     so db.close() happens automatically
}