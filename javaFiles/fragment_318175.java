Class HessianProxyFactory{
    protected HessianConnectionFactory createHessianConnectionFactory(){
        String className= System.getProperty(HessianConnectionFactory.class.getName());
        HessianConnectionFactory factory = null;
        try {
          if (className != null) {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            Class<?> cl = Class.forName(className, false, loader);
            factory = (HessianConnectionFactory) cl.newInstance();
            return factory;
          }
        } catch (Exception e) {
          throw new RuntimeException(e);
        }
        return new HessianURLConnectionFactory();
    }
}