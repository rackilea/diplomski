private void insertTargetNumber(Connection conn, PreparedStatement stmtTargetNumber, Long returnedTargetId, Long returnedNumberId) throws SQLException {
    PreparedStatement statement = (PreparedStatement) stmtTargetNumber;

    try {
        statement = conn.prepareStatement("INSERT INTO stats_target_number (targetId, numberId) VALUES (?, ?)");
        statement.setLong(1, returnedTargetId);
        statement.setLong(2, returnedNumberId);

        int affectedRows = statement.executeUpdate();
        if (affectedRows == 0) {
            throw new SQLException("Creating target failed, no rows affected.");
        } 
    } finally {

    }       
}