public static void testFunction() {
    Properties properties = new Properties();
    properties.put("user", "USERNAMEHERE");
    properties.put("password", "PASSWORDHERE");

    String URL = "jdbc:oracle:thin:@abc:123:def456";
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    String sqltxt = "SELECT MESSAGE FROM USER.SOME_TABLE WHERE DATE = to_date('01-December-2015', 'dd-month-yyyy')";

    try (Connection conn = DriverManager.getConnection(URL, properties);
        PreparedStatement stmt = conn.prepareStatement(sqltxt, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmt.executeQuery();) {

        System.out.println("Records exist? " + rs.next());
    } catch (Exception e) {
        e.printStackTrace();
    }
}