try (Connection connection = DriverManager.getConnection(...)) {
    connection.setAutoCommit(false);
    try (Statement stmt = connection.createStatement()) {
        stmt.executeUpdate(<your first update>);
        stmt.executeUpdate(<your second update>);

        connection.commit();
    } catch (SQLException e) {
        connection.rollback();
        throw e;
    }
}