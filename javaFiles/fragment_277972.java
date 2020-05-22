String csvPath = "C:/Users/Gord/Desktop/sample.txt";
SQLServerBulkCSVFileRecord fileRecord = 
        new SQLServerBulkCSVFileRecord(csvPath, null, "\\|", false);

int colCount = 5;
for (int i = 1; i <= colCount; i++) {
    fileRecord.addColumnMetadata(i, null, java.sql.Types.NVARCHAR, 50, 0);
}

try (SQLServerBulkCopy bulkCopy = new SQLServerBulkCopy(conn)) {
    bulkCopy.setDestinationTableName("dbo.so41144967");

    try {
        // Write from the source to the destination.
        bulkCopy.writeToServer(fileRecord);
    } catch (Exception e) {
        // Handle any errors that may have occurred.
        e.printStackTrace();
    }
}