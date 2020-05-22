class ConnectionBox {
    Connection connection;
    // ...
    Optional<Connection> getConnection() {
        return Optional.ofNullable(connection);
    }
}