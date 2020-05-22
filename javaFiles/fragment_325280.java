PreparedStatement pstmt = null;
Stirng studentUpdate = "UPDATE student SET grade = ? where id = ?";
try {
    pstmt = conn.prepareStatement(studentUpdate);
    pstmt.setString(1, "A");
    pstmt.setInt(2, 34);
    pstmt.executeUpdate();

} catch(Exception a) {
    a.printStackTrace();
}