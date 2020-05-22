<%
String dbURL = "jdbc:mysql://1.1.1.1:3306/db_name";
String dbUser = "";
String dbPass = "";
Connection conn;   
try{
    DriverManager.registerDriver(new com.mysql.jdbc.Driver());
    conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

    Statement statement = conn.createStatement();
    ResultSet resultset =
            statement.executeQuery("select image from tablename");
    response.setContentType("image/jpg");
    while(resultset.next()) {
        Blob bl = resultset.getBlob(1);
        byte[] pict = bl.getBytes(1,(int)bl.length());
        }
        OutputStream o = response.getOutputStream(); 
        o.write(pict);
 }catch (Exception e){
     e.printStackTrace();
  }  
%>