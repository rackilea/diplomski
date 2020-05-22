try {
    int result = statement.executeBatch();
    if (result == Statement.EXECUTE_FAILED) {
        MyLogger.log(Level.ERROR, "batch failed, but driver seems to still be alive.");
    }
} catch (SQLException e) {
    MyLogger.log(Level.ERROR, "the batch failed, and the driver died too.");
}