// use CALL with the name of the stored procedure
String query = "{CALL execSql()}";

// use CallableStatement to obtain the ResultSet
CallableStatement stmt = conn.prepareCall(query)
ResultSet rs = stmt.executeQuery();