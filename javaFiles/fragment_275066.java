Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/mySchema?autoReconnect=true&useSSL=false&rewriteBatchedStatements=true",
    "root", "root");
Statement stmt = conn.createStatement();
int flag = stmt.executeUpdate(sqlString);
LOGGER.info("Flag = {}", flag);