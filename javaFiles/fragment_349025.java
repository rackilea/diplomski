ResultSet rs = stmt.executeQuery(query);
    ResultSetMetaData rsmd = rs.getMetaData();
    int columnCount = rsmd.getColumnCount() ; // returns the number of columns
    for(int i = 1; i < columnCount + 1; i++){
        rsmd.getColumnName(i); //get name
    }