String sql = "SELECT * FROM component WHERE UsernameID = ?";
try (PreparedStatement stmt = conn.prepareStatement()) {
    stmt.setString(1, jLabel5.getText());
    try (ResultSet rs = st.executeQuery()) {
        while (rs.next()) {
            // code here
        }
    }
}