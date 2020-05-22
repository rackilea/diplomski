String connectionUrl = "jdbc:mysql://localhost:3307/mydb?useUnicode=true"
            + "&serverTimezone=" + ZoneId.systemDefault().getId();
System.out.println(connectionUrl);
// jdbc:mysql://localhost:3307/mydb?useUnicode=true&serverTimezone=America/Denver

Connection conn = DriverManager.getConnection(connectionUrl, myUid, myPwd);