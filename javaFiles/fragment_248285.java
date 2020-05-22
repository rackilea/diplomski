class HandleNoInternet implements InvocationHandler {
   private final Object delegate;   // set fields from constructor args
   private final Application app;

   public HandleNoInternet(Application app, Object delegate) {
      this.app = app; 
      this.delegate = delegate;
   }
   public Object invoke(Object proxy, Method method, Object[] args) {
       try {
           // invoke the method on the delegate and handle the exception
           method.invoke(delegate, args);
       } catch (Exception ex) {
           if ( ex.getCause() instanceof NoInternetException ) {
             NoInternetToast.show(app);
           } else {
             throw new RuntimeException(ex);
           }
       }
   }
}