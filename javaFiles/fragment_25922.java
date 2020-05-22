Connection connection = null;
// ...

try {
    connection = cpds.getConnection();
    // ...
} finally {
    // ...
    if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
}