Connection connection = null;

while (connection == null) {
    try {
        connection = DriverManager.getConnection(url, username, password);
    } catch (SQLException e) {
        logger.info("Connecting failed, retrying...");
    }
}

return connection;