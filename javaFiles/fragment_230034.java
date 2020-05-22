ProxyFactory factory = new ProxyFactory();
factory.setSuperclass(entity.getClass());
factory.setInterfaces(new Class[] { MyCustomInterface.class });
Class cls = factory.createClass();

// bind your newly methodHandler to your proxy
((javassist.util.proxy.Proxy) cls).setHandler(new CustomMethodHandler(entity));
EntityClass proxyEntity = cls.newInstance();