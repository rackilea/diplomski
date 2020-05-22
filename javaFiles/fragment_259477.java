default void checkTableHasData(Duration atMost, String tableName) throws Exception {
    check(atMost, "SELECT COUNT(*) FROM " + tableName);
}

default void checkTableRowExistSearchOnColumn(Duration atMost, String tableName, String columnName,
                                              String columnValue) throws Exception {
    check(atMost, "SELECT COUNT(*) FROM " + tableName + " where " + columnName +
                               " = " + columnValue);
}

private void check(Duration atMost, String countStatement) throws Exception {
    try (MysqlQuery mysqlQuery = new MysqlQuery(customersMysqlUrl(host), dbName, user, password)) {

        await().atMost(atMost).pollDelay(Duration.ONE_SECOND).ignoreExceptions().until(
        () -> mysqlQuery.count(countStatement),
        is(Matchers.greaterThan(0)));
    }
}