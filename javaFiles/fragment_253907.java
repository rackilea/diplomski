while (rs.next()) {
    java.sql.Time dbSqlTime = rs.getTime("columnName");
    java.sql.Date dbSqlDate = rs.getDate("columnName");
    java.sql.Timestamp dbSqlTimestamp = rs.getTimestamp("columnName");     
    java.util.Date dbSqlTimeConverted = new java.util.Date(dbSqlTime.getTime());
    java.util.Date dbSqlDateConverted = new java.util.Date(dbSqlDate.getTime());
    System.out.println(dbSqlTimeConverted);
    System.out.println(dbSqlDateConverted);
 }