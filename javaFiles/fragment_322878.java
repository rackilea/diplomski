public User search(String userName, String password, Connection con) throws Exception{
    User user = null;

    String sql = "SELECT USERNAME, PASSWORD FROM T_USERS WHERE USERNAME=? AND PASSWORD=?";

    PreparedStatement pStmt = con.prepareStatement(sql);
    pStmt.setString(1, userName);
    pStmt.setString(2, password);
    ResultSet rS = pStmt.executeQuery();

    if(rS.next()){
        user = new User(rS.getString("USERNAME"), rS.getString("PASSWORD"));
    }

    rS.close();
    pStmt.close();

    return user;
}