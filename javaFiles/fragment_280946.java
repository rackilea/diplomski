public SQLiteDatabaseWrapper(File pathToDB, boolean createNew)
        throws IOException {

    if (!pathToDB.exists()) {
        if (createNew) {
            // Create new database, potentially throws exception
        } else {
            throw new FileNotFoundException();
        }
    }

    // Open connection and setup wrapper
}

public SQLiteDatabaseWrapper(File pathToDB) throws IOException {
    this(pathToDB, false);
}