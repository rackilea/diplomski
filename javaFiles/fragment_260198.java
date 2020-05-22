class MyDAO {
  /* Search user which name contains searchName */
  public List<User> searchUserByName(String searchName) {
    String sql = "select * from USERS where USERNAME like '%" + searchName + "%'";
    List<User> users = new ArrayList<User>();    
    // Execute sql, 
    // open ResultSet, 
    // iterate it and for every ResultRow's row convert to object User
    // Add converted object User to users
    // Free resource
    return users; 
  }
}