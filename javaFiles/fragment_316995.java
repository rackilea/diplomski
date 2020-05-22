public class Foo {
    private final Statement statement;

    public Foo(Connection connection) throws SQLException {
        statement = connection.createStatement(...);
    }
}