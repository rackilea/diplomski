try (
        Connection conn = DriverManager.getConnection(connStr);
        PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO EmployeeDetails ([Date]) VALUES (?)")) {
    String month = "12";   //
    String year = "2006";  // sample data
    String day = "10";     //
    ps.setDate(1, java.sql.Date.valueOf(year + "-" + month + "-" + day));
    ps.executeUpdate();
}