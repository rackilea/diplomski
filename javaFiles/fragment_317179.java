List<Map<String, Object>> rows = new ArrayList<>();
ResultSetMetaData rsmd = rs.getMetaData();
int columnCount = rsmd.getColumnCount();

while (rs.next()) {
      // Represent a row in DB. Key: Column name, Value: Column value
      Map<String, Object> row = new HashMap<>();
      for (int i = 1; i <= columnCount; i++) {
           // Note that the index is 1-based
           String colName = rsmd.getColumnName(i);
           Object colVal = rs.getObject(i);
           row.put(colName, colVal);
      }
      rows.add(row);
}

// Write the list of rows to output
// Recommend to use jackson-ObjectMapper to streaming json directly to outputstream:
response.setContentType("application/json");
response.setCharacterEncoding("UTF-8");
ObjectMapper objectMapper = new ObjectMapper();
objectMapper.writeValue(response.getOutputStream(), rows);