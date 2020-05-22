Statement stmt = connection.createStatement();
ResultSet rs = stmt.executeQuery("select current_timestamp() from dual");
rs.next();
Timestamp ts = rs.getTimestamp(1);
rs.close();
stmt.close();