public class DynamicProxyHandler implements InvocationHandler {
    private Object proxied;
    InvocationChain chain = new InvocationChainImp();

    DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return chain.invoke(proxied, method, args);
    }

}