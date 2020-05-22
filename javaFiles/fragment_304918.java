public void testCorrectSQL() throws Exception {
    MockResultSet result = getStatementResultSetHandler().createResultSet();
    getStatementResultSetHandler().prepareResultSet("select.*isbn,.*quantity.*", result);
    List orderList = new ArrayList();
    orderList.add("1234567890");
    orderList.add("1111111111");
    Bookstore.order(getJDBCMockObjectFactory().getMockConnection(), orderList);
    verifySQLStatementExecuted("select.*isbn,.*quantity.*\\(isbn='1234567890'.*or.*isbn='1111111111'\\)");
}