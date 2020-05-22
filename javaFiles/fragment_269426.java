File dbFile;
try {
    dbFile = File.createTempFile("eap-mirror", ".accdb");
    dbFile.deleteOnExit();
    try (Database db = DatabaseBuilder.create(Database.FileFormat.V2010, dbFile)) {
        System.out.println(db.getFileFormat());
    } catch (IOException ioe) {
        ioe.printStackTrace(System.out);
    }
} catch (Exception e) {
    e.printStackTrace(System.out);
} finally {
    System.out.println("Finally...");
}