public class Examples {
    public int answer(PreparedStatement prepStatement) throws SQLException {
        final ResultSet rs = prepStatement.executeQuery();
        try {
            if (!rs.next()) {
                throw new IllegalStateException("Expected non-empty result");
            }
            return rs.getInt(1);
        } finally {
            rs.close();
        }
    }
}