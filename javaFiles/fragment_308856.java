try {
    conn = DriverManager.getConnection(url, username, password);
    PreparedStatement pstmt = conn.prepareStatement("INSERT INTO `table`
        (pid,tid,rid,tspend,description) VALUE 
        (?,?,?,?,?)");
    pstmt.setString(1, pid );
    pstmt.setString(2, tid);
    pstmt.setString(3, rid);
    pstmt.setInt(4, tspent);
    pstmt.setString(5,des );
    pstmt.executeUpdate();
} catch (Exception e) {
    // whatever you want to do to handle the exception
} finally {
    // close your connection
}