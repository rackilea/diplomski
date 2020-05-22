public static String doSQL() throws SQLException {
    String result = new String();
    String q1 = "SELECT SYS_CONTEXT('USERENV','SESSION_USER') FROM DUAL";
    Connection conn =
            DriverManager.getConnection("jdbc:default:connection");
    PreparedStatement ps = conn.prepareStatement(
            q1
    );
    ResultSet rs = ps.executeQuery();
    while (rs.next())
        result = rs.getString(1);
    return "my udf says"+result;
}