public static void testFunction() {
    Properties properties = new Properties();
    properties.put("user", "USERNAMEHERE");
    properties.put("password", "PASSWORDHERE");

    String URL = "jdbc:oracle:thin:@abc:123:def456";
    String sqltxt = "SELECT MESSAGE FROM USER.SOME_TABLE WHERE DATE = ?";

    try (Connection conn = DriverManager.getConnection(URL, properties);
        PreparedStatement stmt = conn.prepareStatement(sqltxt, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmt.executeQuery();) {

        stmt.setDate(1, Date.valueOf(LocalDate.now().withYear(2015).withMonth(12).withDayOfMonth(1)));
        System.out.println("Records exist? " + rs.next());
    } catch (Exception e) {
        e.printStackTrace();
    }
}