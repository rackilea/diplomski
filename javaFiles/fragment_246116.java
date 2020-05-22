Connection conn = null; 
 String url = "jdbc:mysql://localhost/"; 
 String dbName = "someDb"; 
 String driver = "com.mysql.jdbc.Driver"; 
 String userName = "root"; String password = "password"; 
 try { Class.forName(driver).newInstance();
       conn = DriverManager.getConnection(url+dbName,userName,password);   System.out.println("Connected to the database"); conn.close(); System.out.println("Disconnected from database"); } catch (Exception e) { System.out.println("NO CONNECTION =("); } }