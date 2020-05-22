// execute the query
String query = "{CALL execSql()}";
CallableStatement stmt = conn.prepareCall(query)
ResultSet rs = stmt.executeQuery();

// fill the TableModel with the results
TableModel normalTableModel = DBUtils.resultSetToTableModel(rs);

// create the Swing Table
JTable swingTable = new JTable (transposedTableModel);