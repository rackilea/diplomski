dbConnection.setAutoCommit(false);//commit trasaction manually

String insertTableSQL = "INSERT INTO DBUSER"
            + "(USER_ID, USERNAME, CREATED_BY, CREATED_DATE) VALUES"
            + "(?,?,?,?)";              
PreparedStatement = dbConnection.prepareStatement(insertTableSQL);

preparedStatement.setInt(1, 101);
preparedStatement.setString(2, "mkyong101");
preparedStatement.setString(3, "system");
preparedStatement.setTimestamp(4, getCurrentTimeStamp());
preparedStatement.addBatch();

preparedStatement.setInt(1, 102);
preparedStatement.setString(2, "mkyong102");
preparedStatement.setString(3, "system");
preparedStatement.setTimestamp(4, getCurrentTimeStamp());
preparedStatement.addBatch();
preparedStatement.executeBatch();

dbConnection.commit();