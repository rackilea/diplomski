String EachTable = "";
    Statement GetTableNames = mDatabaseConnection.createStatement();
    ResultSet rs = GetTableNames.executeQuery("SELECT * FROM pparsdb.application LIMIT 1");
    ResultSetMetaData rsmd = rs.getMetaData();
    int columnCount = rsmd.getColumnCount();

    // The column count starts from 1
    for (int i = 1; i < columnCount + 1; i++ ) 
    {
        EachTable += ",application." + rsmd.getColumnName(i);
    }

    System.out.println(EachTable);