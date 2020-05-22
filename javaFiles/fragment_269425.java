File dbFile;
try {
    dbFile = File.createTempFile("eap-mirror", "eap");
    try (Database db = DatabaseBuilder.open(dbFile)) {
        System.out.println(db.getFileFormat());
    } catch (IOException ioe) {
        ioe.printStackTrace(System.out);
    }
} catch (Exception e) {
    e.printStackTrace(System.out);
} finally {
    System.out.println("Finally...");
}