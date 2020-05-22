interface A{
    void x() throws IOException;
}

A proxy = (A) newProxyInstance(classLoader, new Class<?>[]{A.class}, 
  new InvocationHandler() {      
        @Override
        public Object invoke(Object arg0, Method arg1, Object[] arg2) 
            throws Throwable {
            throw new IOException();
        }
   }
);
proxy.x();