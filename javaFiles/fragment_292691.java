public class AbstractQueryCommand<T> implements IQueryCommand<T> {
    abstract protected String getResult(ResultSet rs) throws SQLException;
    ...
}
return new AbstractQueryCommand<String>() {
    @Override
    protected String getResult(ResultSet rs) throws SQLException {
        String result = "";
        while (rs.next()) {
            result = rs.getString("DESCRIPTION");
        }
        return result;
    };
}