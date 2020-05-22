public class MapMapper implements ResultSetMapper<Map<String, Integer>> {
    @Override
    public Map<String, Integer> map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        HashMap<String, Integer> result = new HashMap<>();
        for(int i =1; i <= r.getMetaData().getColumnCount(); i++) {
            String columnName = r.getMetaData().getColumnName(i);
            Integer value = r.getInt(i);
            result.put(columnName, value);
        }
        return result;
    }
}