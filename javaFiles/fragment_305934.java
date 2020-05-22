private static final int i;
static {
    establishDatabaseConnection();
    i = readIntFromDatabase;
    closeDatabaseConnection();
}