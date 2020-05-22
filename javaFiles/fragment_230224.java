public Entity find(Long id) throws SQLException {
    Connection connection = null;
    // ...

    try {
        connection = database.getConnection();
        // ...
    } finally {
        // ...
        if (connection != null) try { connection.close(); } catch (SQLException logOrIgnore) {}
    }

    return entity;
}