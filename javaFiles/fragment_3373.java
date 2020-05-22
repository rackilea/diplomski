public static String submit(String usrn, String psw){
    //String sql = "INSERT INTO tbl_user VALUES('', '"+usrn+"', '"+psw+"')";
    String sql = "INSERT INTO tbl_user VALUES('', ?, ?)";
    String result = "failed";
    try (Connection conn = MySQLAccess.connectDB();
         PreparedStatement pst = conn.prepareStatement(sql)) {
        pst.setString(1, usrn);
        pst.setString(2, psw);
        pst.executeUpdate();
        result = "worked";
    } catch (SQLException e) {
        //handle your exception...
    }
    return result;
}