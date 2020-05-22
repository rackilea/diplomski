public class WhereClause {

    private Integer currentIndex = 0;
    private Map<Integer, Object> parameters = new HashMap<>();
    private StringBuilder whereClause = null;

    public void addParameter(String columnName, Object value) {
        if(whereClause == null) {
            whereClause = new StringBuilder(" WHERE ");
        } else if (currentIndex > 0) {
            whereClause.append(" AND ");
        }
        whereClause.append(columnName).append(" = ?");
        paramenters.put(++currentIndex, value);
    }

    public String getWhereClause() {
        return whereClause != null ? whereClause.toString() : "";
    }

    public Map<Integer, Object> getParamenters() {
        return parameters;
    }
}