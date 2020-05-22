@Stateless
public static class MyBean implements MyBusinessInterface {
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void doSomething(Connection connection) {
        new SomeDAO().doSomething(connection);
    }
}