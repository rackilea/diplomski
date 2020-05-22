ResultSet rs = st.executeQuery("SELECT username, password, host, port FROM  myAllData where id=1");

String myURL = "jdbc:mysql:// " + rs.getString("host") + ":" + rs.getString("port") + "/DBName"
String myUserName = rs.getString("username");
String myPassword = rs.getString("password");

Class.forName("com.mysql.jdbc.Driver");

c = DriverManager.getConnection(myURL, myUserName, myPassword);