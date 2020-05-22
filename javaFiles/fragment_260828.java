public void create(Entity entity) throws SQLException {
    try (
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQL_CREATE);
    ) { 
        statement.setSomeObject(1, entity.getSomeProperty());
        // ...
        statement.executeUpdate();
    }
}