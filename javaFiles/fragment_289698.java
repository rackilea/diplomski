private final Memo<Connection> conn = new Memo<Connection>(
    new Callable<Connection>() {
    public Connection call() throws Exception {
        return new Connection();
    }
});

public Connection getConnection() {
    return conn.get();
}