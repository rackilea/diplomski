public class ConnectionProxy {

    public ConnectionProxy(Object anObject) {
        super(anObject);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {              
        Object result = method.invoke(target, args);
        String methodName = method.getName();

        if (methodName.equals("createStatement")) {
            result = ProxyBuilder.createProxy(result, new StatementProxy(result));
        }

        return result;
    }
}