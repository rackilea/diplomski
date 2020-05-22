final Object aDuck = ...;
TheInterfaceIWant aDuckWrapper = (TheInterfaceIWant) Proxy.newProxyInstance(
    TheInterfaceIWant.class.getClassLoader(),
    new Class[] { TheInterfaceIWant.class },
    new InvocationHandler() {
      public Object invoke(
          Object proxy, Method method, Object[] args)
          throws Throwable {
        return aDuck.getClass().getMethod(
            method.getName(), method.getParameterTypes()).invoke(aDuck, args);
      }
    });