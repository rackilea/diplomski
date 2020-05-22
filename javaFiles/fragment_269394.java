public class SqlRowSetOracleResultSetExtractor implements ResultSetExtractor {

    public Object extractData(ResultSet rs) throws SQLException {
        return createSqlRowSet(rs);
    }

    protected SqlRowSet createSqlRowSet(ResultSet rs) throws SQLException {
        CachedRowSet rowSet = newCachedRowSet();
        rowSet.populate(rs);
        return new ResultSetWrappingSqlRowSet(rowSet);
    }

    protected CachedRowSet newCachedRowSet() throws SQLException {
        return new OracleCachedRowSet();
    }
}