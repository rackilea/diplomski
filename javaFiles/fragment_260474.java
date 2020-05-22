String sql = "SELECT * FROM MyTable WHERE Stat IN (?,?,?,?)";
try (PreparedStatement stmt = conn.prepareStatement(sql)) {
    stmt.setString(1, "OPEN");
    stmt.setString(2, "CLOSED");
    stmt.setString(3, "WOUNDED");
    stmt.setString(4, "IN PROGRESS");
    try (ResultSet rs = stmt.executeQuery()) {
        // use rs here
    }
}