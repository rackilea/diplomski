public String addDynamicParameters(String query, List<Object> parameters) {
    StringBuilder queryBuilder = new StringBuilder(query);
    queryBuilder.append("?");
    for (int i = 1; i < parameters.size(); i++) {
        queryBuilder.append(", ?");
    }
    queryBuilder.append(") ");
    return queryBuilder.toString();
}

public void addParameters(PreparedStatement pstmt, List<Object> parameters) {
    int i = 1;
    for(Object param : parameters) {
        pstmt.setObject(i++, param);
    }
}

public void testDynamicParameters() {
    String query = "SELECT col3 FROM tableX WHERE col1 = ? AND col2 IN (";
    List<Object> parametersForIn = ...;
    query = addDynamicParameters(query, parametersForIn);
    List<Object> parameters = ...;
    PreparedStatement pstmt = ...; //using your Connection object...
    parameters.addAll(parametersForIn);
    addParameters(pstmt, parameters);
    //execute prepared statement...
    //clean resources...
}