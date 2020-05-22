try (Connection conn = DriverManager.getConnection(url, username, password)) {
    try (PreparedStatement pstmt = conn.prepareStatement(/*sql here*/)) {
        // Your code here
    } catch (SQLException sqle) {
        // handle exceptions from the statement
    }
} catch (SQLException outerSqlEx) {
    // handle exceptions from connecting
}