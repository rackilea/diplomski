String updateTableSQL = "UPDATE student SET 'studentid' = ? 'firstname' = ? 'lastname' = ? 'address' = ? dateofbirth' = ?  WHERE " + cond_col + "= ?";
try {
    dbConnection = getDBConnection();
    preparedStatement = dbConnection.prepareStatement(updateTableSQL);

    preparedStatement.setInt(1, studentid); 
    preparedStatement.setString(2, firstname); 
    preparedStatement.setString(3, lastname);
    preparedStatement.setString(4, address); 
    preparedStatement.setString(5, dateofbirth);
    preparedStatement.setString(6, cond_val);