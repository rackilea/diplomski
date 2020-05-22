String SQLStatement = null;
...
SQLStatement = "SELECT count(*) FROM ? WHERE ? = ?";
ps = conn.prepareStatement(SQLStatement);
ps.setString(1, DBtablename);
ps.setString(2, DBStatus);                
ps.setString(3, DBArgument);