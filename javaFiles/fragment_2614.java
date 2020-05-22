public long getCurrentUserId() {
      //..
     try {
          InitialContext ic = new InitialContext();
          SessionContext sessionContext=(SessionContext)   ic.lookup("java:comp/env/sessionContext");

          System.out.println("look up injected sctx: " + sessionContext);

     //Now do what you want with the Session context:
         Principal callerPrincipal = sessionContext.getCallerPrincipal();
    //..
      } catch (NamingException ex) {
          throw new IllegalStateException(ex);
      }
//..

}