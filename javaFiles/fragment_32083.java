private void createTable() throws SQLException {
    String sqlCreate = "CREATE TABLE IF NOT EXISTS " + this.getTableName()
            + "  (brand           VARCHAR(10),"
            + "   year            INTEGER,"
            + "   number          INTEGER,"
            + "   value           INTEGER,"
            + "   card_count           INTEGER,"
            + "   player_name     VARCHAR(50),"
            + "   player_position VARCHAR(20))";

    Statement stmt = conn.createStatement();
    stmt.execute(sqlCreate);
}