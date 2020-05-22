try {
    // This is not needed anymore with the new driver
    //Class.forName("com.mysql.jdbc.Driver");

    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false", "root", "");

    connection.setAutoCommit(false);
    Statement statement = connection.createStatement();

    for (String x : objectsToStores) {
        statement.executeUpdate("INSERT INTO USER_DATA (email) VALUES ('" + x + "')");
    }

    // I just moved this line down
    ResultSet rs = statement.executeQuery("select * from user_data");
    while (rs.next())
        System.out.println(rs.getString(1));

    connection.commit();
    statement.close();
    connection.close();

} catch (Exception e) {
    throw new RuntimeException(e);
}