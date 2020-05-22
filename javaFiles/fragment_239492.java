@SuppressWarnings("serial")
public class MockFailureException extends SQLException {
    private MockFailureException() {
        super("The database has been deliberately faulted as part of a test-case");
    }
}

private class MockFailureWrapper implements InvocationHandler {

    final Object obj;

    private MockFailureWrapper(Object obj) {
        this.obj = obj;
    }

    @Override public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
        if(dbFailure && ("commit".equals(m.getName()) || m.getName().startsWith("execute")))
            throw new MockFailureException();
        Object result;
        try {
            result = m.invoke(obj, args);
            if(result instanceof PreparedStatement)
                result = java.lang.reflect.Proxy.newProxyInstance(
                        result.getClass().getClassLoader(),
                        result.getClass().getInterfaces(),
                        new MockFailureWrapper(result));
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
        } catch (Exception e) {
            throw new RuntimeException("unexpected invocation exception: " + e.getMessage());
        }
        return result;
    }

}


public Connection newConnection() throws SQLException {
    Connection connection = DriverManager.getConnection("jdbc:h2:mem:"+uuid+";CREATE=TRUE;DB_CLOSE_ON_EXIT=FALSE");
    return (Connection)java.lang.reflect.Proxy.newProxyInstance(
            connection.getClass().getClassLoader(),
            connection.getClass().getInterfaces(),
            new MockFailureWrapper(connection));
}