private boolean checkDataBase() {
    /**
     * Does not open the database instead checks to see if the file exists
     * also creates the databases directory if it does not exist
     * (the real reason why the database is opened, which appears to result in issues)
     */

    File db = new File(myContext.getDatabasePath(DB_NAME).getPath()); //Get the file name of the database
    if (db.exists()) return true; // If it exists then return doing nothing

    // Get the parent (directory in which the database file would be)
    File dbdir = db.getParentFile();
    // If the directory does not exist then make the directory (and higher level directories if need be)
    if (!dbdir.exists()) {
        dbdir.mkdirs();
    }
    return false;
}