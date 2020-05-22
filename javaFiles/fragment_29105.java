Class.forName("com.mysql.jdbc.Driver");
Connection conn=DriverManager.getConnection("jdbc:mysql//localhost/mydatabase","user","pass");
PreparedStatement stmt = conn.prepareStatement("SELECT NAME FROM stocks1 WHERE FULLNAME is in (SELECT FULLNAME FROM arraystocks)"); 
ResultSet t=stmt.executeQuery(); 
while(t.next()) {
    System.out.println(t.getString("NAME"));
}