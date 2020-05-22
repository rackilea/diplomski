final ProducerTemplate template = context.createProducerTemplate();
final Endpoint endpoint = context.getEndpoint("direct:start");

ClassLoader classLoader = context.getApplicationContextClassLoader();
InvocationHandler invocationHandler = new InvocationHandler() {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return template.requestBodyAndHeader(endpoint, args, "operationName", method.getName(), method.getReturnType());
    }
};

TestService service = (TestService) ProxyHelper.getProxy(classLoader, new Class[] {TestService.class}, invocationHandler);