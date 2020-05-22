callableStatement = dbConnection.prepareCall("call `set`(?,?,?,?)");
callableStatement.setInt(1, id);
callableStatement.setString(2, name);
callableStatement.setString(3, sal);
callableStatement.setString(4, dept);
callableStatement.executeUpdate();