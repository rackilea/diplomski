public <T> T query(String sql, IResultSetHandler<T> resultSetHandler ) throws SQLException {
    Statement statement = null;
    try {
        statement = connection.createStatement();
        final ResultSet rs = connection.executeQuery(sql);
        final T result = resultSetHandler.handle(rs);
        return result;
    } finally {
        if(statement != null) {
            statement.close();
        }
    }
}

public interface IResultSetHandler<T> {
    T handle(ResultSet rs);
}

public static void main(String[] args) {
    JDBCConnect jdbcConn = new JDBCConnect();
    List<String> ids = jdbcConn.query(sql, new IResultSetHandler<List<String>>() {
        public List<String> handle(ResultSet rs) {
            List<String> ids = new ArrayList<String>();
            while(rs.next()) {
                ids.add(rs.getString("id"));
            }
            return ids;
        }
    });
}