@After
public void tearDown() throws Exception {
    vacancyDao.deleteAll();
    try (Connection connection = new ConnectionFactory().getConnection()) {
        Statement statement = connection.createStatement();
        statement.executeUpdate("ALTER TABLE job ALTER COLUMN id RESTART WITH 1");
    }
}