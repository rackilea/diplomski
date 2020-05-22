try (Connection conn = DriverManager.getConnection(connURL);
     PreparedStatement ps = conn.prepareStatement(sql);) {

    // do something

} catch (SQLException e) {
    e.printStackTrace();
}