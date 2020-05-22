private Long insertTarget(Connection conn, Statement stmtTarget, Target target) throws SQLException {
    PreparedStatement statement = (PreparedStatement) stmtTarget;
    ResultSet generatedKeys = null;

    try {
    statement = conn.prepareStatement("INSERT INTO stats_target (name) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
    statement.setString(1, target.getName());

    int affectedRows = statement.executeUpdate();
    if (affectedRows == 0) {
        throw new SQLException("Creating target failed, no rows affected.");
    }

    generatedKeys = statement.getGeneratedKeys();
    if (generatedKeys.next()) {
        target.setTargetId(generatedKeys.getLong(1));
    } else {
        throw new SQLException("Creating target failed, no generated key obtained.");
    }      
    } finally {
        if (generatedKeys != null) try { generatedKeys.close(); } catch (SQLException logOrIgnore) {}
     }

    return target.getTargetId();
}