Class.forName("com.mysql.jdbc.Driver"); 
Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/salestracker", "salestracker", "salestracker"); 
PreparedStatement s = conn.prepareStatement("select count(*) from client"); 
ResultSet rs = s.executeQuery(); 
rs.next(); 
System.out.println(rs.getString(1));