private static String hostName = "<your host name>";
    private static String dbName = "sys";
    private static String user = "<user name>";
    private static String password = "password";
    private static String portNumber = "3306";

    @RequestMapping("/hello")
    public String index() throws SQLException {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        try {
            String url = "jdbc:mysql://"+hostName+":"+portNumber+"/"+dbName+"?verifyServerCertificate=true&useSSL=true&requireSSL=false&serverTimezone=UTC";
            conn = DriverManager.getConnection(url, user, password);

        } catch (SQLException e) {
            System.out.println("error!!!!");
            System.out.println(e.getMessage());
            e.printStackTrace();
            return e.getMessage();
        }
        return conn.getCatalog();
    }