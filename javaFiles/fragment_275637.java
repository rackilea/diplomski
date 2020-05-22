ClassLoader ctxtCl = Thread.currentThread().getContextClassLoader();
try {
    Thread.currentThread().setContextClassLoader(getClass().getClassLoader());

    try {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }

    dbConnection = DriverManager.getConnection("jdbc:derby://localhost:1527/testdb");
} catch (SQLException e) {
    /* log, etc. */
} finally {
    Thread.currentThread().setContextClassLoader(ctxtCl);
}