String driver="com.mysql.jdbc.Driver";
    String url="jdbc:mysql://localhost:3306/dbname";
    String uname="username";
    String pass="password";
    Class.forName(driver);
    Connection c=(Connection) DriverManager.getConnection(url,uname,pass);
    Statement s=c.createStatement();
    s.executeUpdate("INSERT INTO `time_entry`(pid,tid,rid,tspend,description) VALUE ('"+pid+"','"+tid+"','"+rid+"',"+tspent+",'"+des+"')");