public class PreparedStatementCloser implements Closeable {

    private PreparedStatement preparedStatement;

    public PreparedStatementCloser(PreparedStatement preparedStatement) {
        this.preparedStatement = preparedStatement;
    }

    @Override
    public void close() throws IOException {
        try {
            preparedStatement.close();
        } catch (SQLException e) {
            throw new IOException("Exception encountered while closing prepared statement", e);
        }
    }

}