public User authenticateUser(String userName, String pass) {
    User user = null; // necessary unless you do something in the exception handler
    ResultSet result = null;
    PreparedStatement ps = null;
    try {
      ps = conn.prepareStatement(
          "select readonly * from users where username = \"" + userName  + "\" AND " + "password = \"" + pass + "\"");
      result = ps.executeQuery();
      while (result.next()) {
         user = new User(result.getString(1), result.getString(2));
      }
    } catch (SQLException sqle) {
      //do stuff on fail
    }finally{
        if (result != null) {
            try {
                result.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
        }
    }
return user;