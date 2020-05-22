try {
    Class.forName("com.mysql.jdbc.Driver");
}
catch (ClassNotFoundException e) {
    throw new Exception("No database");
}
String connectionURL = "jdbc:mysql://localhost:3306/dbname";
con = DriverManager.getConnection(connectionURL, "root", "password");