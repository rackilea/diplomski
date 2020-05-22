String sql = "insert into job_input values (?, ?)";
Connection connection = null;
PreparedStatement statement = null;

try {
    connection = database.getConnection();
    connection.setAutoCommit(false);
    statement = connection.prepareStatement(sql);

    for (List row : data) {
        statement.setInt(1, Integer.parseInt(row.get(0).toString()));
        statement.setInt(2, Integer.parseInt(row.get(1).toString()));
        statement.addBatch();
    }

    statement.executeBatch();
    connection.commit();
    return true;
} catch (SQLException e) {
    if (connection != null) try { connection.rollback(); } catch (SQLException logOrIgnore) {}
    e.printStackTrace();
    return false;
} finally {
    if (statement != null) try { statement.close(); } catch (SQLException logOrIgnore) {}
    if (connection != null) try { connection.close(); } catch (SQLException logOrIgnore) {}
}