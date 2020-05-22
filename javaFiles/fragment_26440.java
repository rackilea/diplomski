String query = "select COUNT(*) as count from  TRACKER where TYPE = ?"+
               " and LAST_MODIFIED_TIME > LAST_RETREIVED_TIME";
prepStmt = connection.prepareStatement(query);
prepStmt.setString(1, "xml");
resultset = prepStmt.executeQuery();
resultset.next();   
int rowcount = resultset.getInt("count");