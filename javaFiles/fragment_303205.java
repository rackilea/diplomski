String connectionURL = "jdbc:mysql://localhost:3306/database";
Connection con = null;
PreparedStatement stmt = null;

try {
    Class.forName("com.mysql.jdbc.Driver");
    con = DriverManager.getConnection(connectionURL);
    stmt = con.prepareStatement(statement);

    for (Object o : list) {    // this is a list of your Java entity class
        stmt.setString(1, "foo");    // this is to update the parameters in the PreparedStatement
        stmt.setString(2, "bar");

         stmt.addBatch();     //  this adds the PreparedStatement to the batch of statements to execute
    }

    stmt.executeBatch();

} catch (SQLException e) {
    e.printStackTrace();
} catch (Exception e) {
    e.printStackTrace();
} finally {
    if (stmt != null) {
        stmt.close();
    }
    if (con != null) {
        con.close();
    }
}