try {
     Class.forName("com.mysql.jdbc.Driver");
     conn = DriverManager.getConnection(dbURL, username, password);
} catch (SQLException e1) {
     e1.printStackTrace();
}
 catch (ClassNotFoundException e) {
     e.printStackTrace();
}