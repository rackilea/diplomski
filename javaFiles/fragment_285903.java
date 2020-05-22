try (Connection con = DriverManager.getConnection(someConnection, user, password)) {
    try (PreparedStatement pstmt = con.prepareStatement(sqlStatement)) {
        pstmt.executeUpdate();
    }

    try (PreparedStatement pstmt = con.prepareStatement(anotherSqlStatement)) {
        pstmt.executeUpdate();            
    }
}