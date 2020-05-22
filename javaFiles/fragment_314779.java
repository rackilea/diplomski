public static void resetDatabase(String dataSetFilename) throws DatabaseException {
    IDatabaseConnection connection = null;
    try {
        connection = getDatabaseConnection();
        disableDatabaseConstraints(connection);
        executeDatabaseReset(connection, dataSetFilename);
    } catch (Exception ex) {
        throw new DatabaseException(ex);
    } finally {
        enableDatabaseConstraints(connection);
    }
}

private static void disableDatabaseConstraints(IDatabaseConnection connection) throws DatabaseException {
    try {
        Statement disableConstraintsStatement = connection.getConnection().createStatement();
        disableConstraintsStatement.execute("exec sp_MSforeachtable \"ALTER TABLE ? NOCHECK CONSTRAINT ALL\"");
        disableConstraintsStatement.execute("exec sp_MSforeachtable \"ALTER TABLE ? DISABLE TRIGGER ALL\"");
    } catch (SQLException ex) {
        throw new DatabaseException(ex);
    }
}

private static void enableDatabaseConstraints(IDatabaseConnection connection) throws DatabaseException {
    try {
        Statement enableConstraintsStatement = connection.getConnection().createStatement();
        enableConstraintsStatement.execute("exec sp_MSforeachtable \"ALTER TABLE ? CHECK CONSTRAINT ALL\"");
        enableConstraintsStatement.execute("exec sp_MSforeachtable \"ALTER TABLE ? ENABLE TRIGGER ALL\"");
    } catch (SQLException ex) {
        throw new DatabaseException(ex);
    }
}