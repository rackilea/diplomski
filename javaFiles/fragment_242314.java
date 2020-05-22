String sql = "...";
try (Connection con = ds.getConnection();
    PreparedStatement ps = con.prepareStatement(sql)) {
    //...
} catch (SQLException e) {
    //ALWAYS handle your exceptions as well
}