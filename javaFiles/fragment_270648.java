public void insertFile(String filename, InputStream fis, int length, String owner){
    String sql = "INSERT INTO files(filename, file, owner) VALUES(?, ?, ?)";
    try (Connection conn = DriverManager.getConnection(url);
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, filename);
        pstmt.setBinaryStream(2, fis, length);
        pstmt.setString(3, owner);
        pstmt.executeUpdate();
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}