public Object getObject() throws Exception {
    Object o = new MadeUpInterface() {};
    ProxyFactory proxyFactory = new ProxyFactory(o);
    for (MethodInterceptor methodInterceptor : methodInterceptors) {
        proxyFactory.addAdvice(methodInterceptor);
    }
    return proxyFactory.getProxy();
}