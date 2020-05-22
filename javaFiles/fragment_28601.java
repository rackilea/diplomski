ResultSet rs = preparedStatement.executeQuery();
    if (rs.next()) {
         //example
        String email = rs.getString(1);
        String pw = rs.getString(2);
    }
    else{
         //no results!!
    }