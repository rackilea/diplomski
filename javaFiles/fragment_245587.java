public static void main(String[] args) throws SQLException {
    long chatId = 432878720L;
    String what = "*";
    String from = "BtcUser";
    ResultSet rs = f(what, from, chatId);
    if (rs.next()) {
        System.out.println("HELLO");
    }
}

private static ResultSet f(String what, String from, long chatId) throws SQLException {
    String sql = "SELECT "+what+" FROM "+from+" WHERE chatId = ?;";
    try (Connection con = DriverManager.getConnection(url)) {
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setLong(1, chatId);
        return pst.executeQuery();
    }
}