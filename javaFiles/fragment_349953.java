public void ftpTableCheck(String host, String port, String username, String password) {
    try {
        String query = "SELECT (count(*) > 0) as found FROM ftp WHERE Host LIKE ? AND Username LIKE ?";
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setString(1, host);
        pst.setString(2, username);

        try (ResultSet rs = pst.executeQuery()) {
            // Only expecting a single result
            if (rs.next()) {
                boolean found = rs.getBoolean(1); // "found" column
                if (found) {
                    // You have rows
                } else {
                    // You have no rows
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}