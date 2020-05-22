public class ResultSetCloser implements Closeable {

    private ResultSet resultSet;

    public ResultSetCloser(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    @Override
    public void close() throws IOException {
        try {
            resultSet.close();
        } catch (SQLException e) {
            throw new IOException("Exception encountered while closing result set", e);
        }
    }

}