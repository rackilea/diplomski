final Interface primary = ...;
return (Interface) Proxy.newProxyInstance(Inteface.class.getClassLoader(),
   new Class[] { Interface.class },
   new InvocationHandler() {
     public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
       // if m is a method that you want to change the behaviour of, return something
       // by default, delegate to the primary
       return m.invoke(primary, args);
     }
   });