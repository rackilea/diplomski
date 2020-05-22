try {
    Connection con;
    Statement stmt;
        String url = "jdbc:odbc:GameData.mdb";
    // DATABASE CONNECTION MAGIC :-)
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    con = DriverManager.getConnection(url, "user", "password");
    stmt = con.createStatement();
    // DELETE SOME SOME STUDENT DATA (RARELY USED IN GOOD PRACTICE)
    stmt.executeUpdate("delete from students where phone = '000-0000'");

    // DATABASE CLOSE/CLEANUP
    stmt.close();
    con.close();
}
catch(Exception e) {
    e.printStackTrace();
}