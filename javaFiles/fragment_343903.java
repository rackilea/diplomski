private Long insertNumber(Connection conn, PreparedStatement stmtNumber, TargetNumber t) throws SQLException {
    PreparedStatement statement = (PreparedStatement) stmtNumber;
    ResultSet generatedKeys = null;   

    try {
    statement = conn.prepareStatement("REPLACE INTO stats_number (msisdn) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
    statement.setString(1, t.getMsisdn());

    int affectedRows = statement.executeUpdate();
    if (affectedRows == 0) {
        throw new SQLException("Creating number failed, no rows affected.");
    }

    generatedKeys = statement.getGeneratedKeys();
    if (generatedKeys.next()) {
        t.setNumberId(generatedKeys.getLong(1));
    } else {
        throw new SQLException("Creating number failed, no generated key obtained.");
    }      
    } finally {
        if (generatedKeys != null) try { generatedKeys.close(); } catch (SQLException logOrIgnore) {}
     }

    return t.getNumberId();     
}