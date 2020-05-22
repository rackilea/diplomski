public boolean isLoginFree(String login) throws SQLException {
    PreparedStatement pst = con.prepareStatement("select login " + 
                                                 "from User " + 
                                                 "where login=?");
    pst.setString(1, login);
    ResultSet rs = pst.executeQuery();
    return !rs.first();
}