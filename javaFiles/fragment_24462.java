try {
    statement = connection.createStatement();
    statement.execute(dataInsertQuery);
} catch (SQLException e) {
        e.printStackTrace();
} finally {
    if (statement != null) statement.close();
}