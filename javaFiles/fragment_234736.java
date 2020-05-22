static public ResultSet getData(String sql, String username, String password)
        throws ClassNotFoundException, SQLException {
    PreparedStatement pst = con.prepareStatement(sql);
    pst.setString(1, username);
    pst.setString(2, password);
    ResultSet rs = pst.executeQuery();
    return rs;
}