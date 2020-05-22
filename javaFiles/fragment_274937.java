private Connection connectToDB(String username, String password) {
    try {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/" + DATABASE;
        Properties objProperties = new Properties();
        objProperties.put("user", username);
        objProperties.put("password", password);
        objProperties.put("useUnicode", "true");
        objProperties.put("characterEncoding", "utf-8");

        Connection con = DriverManager.getConnection(url, objProperties);
        return con;
    } catch (Exception ex) {
        System.out.println("Connection to sql database failed.");
        ex.printStackTrace();
        return null;
    }
}