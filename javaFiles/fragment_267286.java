String sql = "INSERT INTO COMPANY (NO, ID) VALUES (?, ?)";
try (PreparedStatement pstmt = conn.prepareStatement(sql);) {

    pstmt.setInt(1, 7);   // Set NO
    pstmt.setArray(2, array);  // Set ID

    pstmt.executeUpdate();  // Execute the query
}