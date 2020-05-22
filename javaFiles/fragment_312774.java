String csvFileSpec = "C:/Users/Gord/Desktop/BookData.csv";
String dbFileSpec = "C:/Users/Public/JackcessTest.accdb";
String tableName = "Book";

try (Database db = new DatabaseBuilder()
        .setFile(new File(dbFileSpec))
        .setAutoSync(false)
        .open()) {

    new ImportUtil.Builder(db, tableName)
            .setDelimiter(",")
            .setUseExistingTable(true)
            .setHeader(false)
            .importFile(new File(csvFileSpec));

    // this is a try-with-resources block, 
    //     so db.close() happens automatically
}