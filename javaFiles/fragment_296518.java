java.util.Properties prop = new java.util.Properties();
    prop.put("oracle.jdbc.V8Compatible", "true"); 
    prop.put("user", "user");
    prop.put("password", "password");
   Connection conn = 
  DriverManager.getConnection("jdbc:oracle:thin:@server:port:SID",prop);