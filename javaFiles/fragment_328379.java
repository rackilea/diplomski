try {
    TimeZone timeZone = TimeZone.getTimeZone("yourTimeZone");
    TimeZone.setDefault(timeZone);
    Class.forName("oracle.jdbc.OracleDriver");
    conn = DriverManager.getConnection("connStr", "myUserName", "myPswd");
    ...