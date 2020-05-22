try {
    Connection conn = DriverManager.getConnection(url);
    return conn;
} catch (SQLException e) {
    return null;
}