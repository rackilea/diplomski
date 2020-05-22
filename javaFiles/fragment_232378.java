session.doWork(new Work() {
    @Override
    public void execute(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute("SET GLOBAL group_concat_max_len=10024");
        }
    }
});