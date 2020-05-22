public void create(Entity entity) throws SQLException {
    // Declare.
    Connection connection = null;
    PreparedStatement statement = null;

    try { 
        // Acquire.
        connection = database.getConnection();
        statement = connection.prepareStatement(SQL_CREATE);

        // Use.
        statement.setSomeObject(1, entity.getSomeProperty());
        // ...
        statement.executeUpdate();
    } finally {
        // Close.
        if (statement != null) try { statement.close(); } catch (SQLException logOrIgnore) {}
        if (connection != null) try { connection.close(); } catch (SQLException logOrIgnore) {}
    }
}