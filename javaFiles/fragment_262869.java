public class SqlTask implements Callable<ResultSet> {

    private String sql;

    public SqlTask(final String sql) {
        this.sql = sql;
    }

    @Override
    public ResultSet call() throws Exception {
        Connection connection = ...; // get connection
        Statement stmt = connection.createStatement();
        return stmt.executeQuery(this.sql);
    }
}