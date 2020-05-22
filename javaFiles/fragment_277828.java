try (Connection con = DriverManager.getConnection(connectionUrl)) {
    try (PreparedStatement s = con.prepareStatement(
            "SELECT language FROM vocabulary WHERE phrase LIKE ?")) {
        s.setString(1, "%γιορτή%");
        try (ResultSet rs = s.executeQuery()) {
            if (rs.next()) {
                System.out.println(rs.getString("language"));
            }
        }
    }
} catch (Exception e) {
    e.printStackTrace(System.out);
}