public static String DB_FILEPATH = "/data/data/{package_name}/databases/database.db";

/**
 * Copies the database file at the specified location over the current
 * internal application database.
 * */
public boolean importDatabase(String dbPath) throws IOException {

    // Close the SQLiteOpenHelper so it will commit the created empty
    // database to internal storage.
    close();
    File newDb = new File(dbPath);
    File oldDb = new File(DB_FILEPATH);
    if (newDb.exists()) {
        FileUtils.copyFile(new FileInputStream(newDb), new FileOutputStream(oldDb));
        // Access the copied database so SQLiteHelper will cache it and mark
        // it as created.
        getWritableDatabase().close();
        return true;
    }
    return false;
}