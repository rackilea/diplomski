protected void initialize() throws SQLException {
    updateCount = -1;
    resultQueue.clear();
    genKeyResultSet = null;
    tds.clearResponseQueue();
    // FIXME Should old exceptions found now be thrown instead of lost?
    messages.exceptions = null;
    messages.clearWarnings();
    closeAllResultSets();
}