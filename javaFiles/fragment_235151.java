Class.forName("com.mysql.jdbc.Driver");
    String url = "jdbc:mysql://localhost:3306/abc";
    String username = "root";
    String password = "root";
    Connection connection = DriverManager.getConnection(url, username, password);

    Statement stmt = connection.createStatement();

    String filename = "d:/outfile.sql";
    String tablename = "abc";
    stmt.executeQuery("SELECT * INTO OUTFILE \"" + filename + "\" FROM " + tablename);