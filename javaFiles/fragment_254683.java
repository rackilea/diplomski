// Not needed nowadays: Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
String sql = "select KB_Title from JD where KB_Title like ?";
try (Connection conn = DriverManager.getConnection("jdbc:ucanaccess://src\\Mydb.accdb");
    PreparedStatement pst = conn.prepareStatement(sql)) {
    pst.setString(1, "%" + temp.trim() + "%");
    try (ResultSet rs = pst.executeQuery()) {
        while (rs.next()) {
            value = rs.getString(1);
            complete.addItem(rs.getString("KB_Title"));
        }
    }
}