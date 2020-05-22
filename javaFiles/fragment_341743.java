try (Connection conn = DriverManager.getConnection(connURL);) {
    try (PreparedStatement ps = conn.prepareStatement(sql);) {

        // do something

    }
} catch (SQLException e) {
    e.printStackTrace();
}