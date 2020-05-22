public static boolean checkMemberID(int memberId) throws SQLException, ClassNotFoundException {
    Connection conn=DBConnection.getDBConnection().getConnection();
    Statement stm = conn.createStatement();
    ResultSet rst = stm.executeQuery("SELECT * FROM members WHERE memberId='"+memberId+"'");

    return rst.next();
}