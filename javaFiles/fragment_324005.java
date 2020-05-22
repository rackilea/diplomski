public static String convertResultSetToJson(ResultSet resultSet) throws SQLException {
    JSONArray json = new JSONArray();
    ResultSetMetaData metadata = resultSet.getMetaData();
    int numColumns = metadata.getColumnCount();

    //iterate rows
    while (resultSet.next())  {
        JSONObject obj = new JSONObject();      //extends HashMap
        //iterate columns
        for (int i = 1; i <= numColumns; ++i) {
            String column_name = metadata.getColumnName(i);
            obj.put(column_name, resultSet.getObject(column_name).toString());
        }
        json.add(obj);
    }
    JSONObject resultsObject = new JSONObject();
    resultsObject.put('results', json); 
    return resultsObject.toJSONString();
}