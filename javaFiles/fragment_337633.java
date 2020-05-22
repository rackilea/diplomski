public List<String> displayName() throws Exception // get all the name
{
    String sql = "Select name from admin";
    List<String> names = new ArrayList<>();
    DatabaseConnection db = new DatabaseConnection();
    try (Connection conn = db.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
            names.add(rs.getString("name"));
        }
    }
    return names;
}