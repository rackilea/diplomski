public boolean checkDatabaseExists(...) {
    try {
        ... do the things you need to check the database exists.
        return true;
    } catch (Exception e) {
        return false;
    }
}