Class.forName("com.mysql.cj.jdbc.Driver");
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Imenik?autoReconnect=true&useSSL=false","root","root");
PreparedStatement ps = (PreparedStatement) conn.prepareStatement("select * from imenik");
ResultSet result = ps.executeQuery();
while(result.next()) {
    System.out.println(result.getString(1) + "   " +result.getString(2) + "   " +result.getString(3) );

}