Class.forName("oracle.jdbc.driver.OracleDriver");
Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","scott","tiger");
Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery("select text from user_source where name = 'YOURTRIGGER'");
if( rs.next())
    System.out.println(rs.getString(1));
conn.close();