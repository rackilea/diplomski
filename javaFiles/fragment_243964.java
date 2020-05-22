ResultSet res = pstmt.executeQuery();
    CassandraResultSet crs = res.unwrap(CassandraResultSet.class);
    crs.next() ;
    ResultSetMetaData rsmd = crs.getMetaData();
        cols = rsmd.getColumnCount();
        for(int i=1 ; i <= cols ; i++) {
          String colNm = rsmd.getColumnName(i);
          String colVal = null;
          String colType = rsmd.getColumnTypeName(i);
          if (colType.equals("JdbcLong")) {
              colVal = "" + crs.getLong(i);
          } else if (colType.equals("JdbcInteger")) {
              colVal = "" + crs.getInt(i);
          } else {
              colVal = crs.getString(i);