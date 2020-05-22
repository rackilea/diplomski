ClientProxyFactoryBean factory = new ClientProxyFactoryBean();
// Configure factory
MyService serviceClient = (MyService) factory.create(MyService.class);
MyService  proxy = (MyService) Proxy.newProxyInstance(
        ServiceInvocationHandler.class.getClassLoader(), 
        new Class[] { MyService.class },
        new ServiceInvocationHandler(serviceClient));