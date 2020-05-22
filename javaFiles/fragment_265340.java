String sql = "INSERT INTO Projektname(projektname) VALUES(?)";

try (Connection conn = this.connect();
    PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, txtFd_name.getText());
        pstmt.executeUpdate();
} catch (SQLException e) {
    System.out.println(e.getMessage());
}