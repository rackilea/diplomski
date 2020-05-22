@TransactionAttribute(REQUIRED)
void move(String newLocation, int fileId) throws CouldNotMoveException, DatabaseException {
    try {
        database.updateFileLocation(fileId, newLocation);
    } catch (Exception exc) {
        throw new DatabaseException(exc);
    }
    try {
        file.copyFile(fileId, newLocation);
    } catch (IOException exc) {
        throw new CouldNotMoveException(exc);
    }
}