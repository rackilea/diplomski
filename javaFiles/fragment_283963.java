String query = "select * from item_master where catid = ? and des = ?";
try (PreparedStatement ps = conn.prepareStatement(query)) {
   ps.setInt(1, id1);
   ps.setString(2, sString);
   try (ResultSet rs = ps.executeQuery()) {
       // ...
   }
} catch (SQLException e) {
   e.printStackTrace();
}