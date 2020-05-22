/*
  * Retrieves a UserProfile from the database based on a username and password
  * Needs Apache Commons Codec package otherwise you have to use MessageDigest 
  * which gives a binary SHA-1
  * @param username The username to fetch
  * @param password The unhashed password
  * @return The UserProfile or null if the user was not found in the DB
  */ 
 private static UserProfile retrieveUserProfile(String username, char[] password) 
    throws SQLException {
     password  = DigestUtils.sha1Hex(password);
     //Assuming a pre-setup JDBC Connection object - `con`
     final String updateString = "SELECT userName, password FROM userProfiles" 
       + "WHERE username = ? AND password = ? LIMIT 1";
     PreparedStatement retrieveUserProfile = con.prepareStatement(updateString)
     retrieveUserProfile.setString(1,"username");
     retrieveUserProfile.setString(2,"password");
     ResultSet rs = retrieveUserProfile.execute();
     if(rs.next()) {
         return new UserProfile(username,password);
     }
     else {
         //User Not found
         return null;
     }
 }