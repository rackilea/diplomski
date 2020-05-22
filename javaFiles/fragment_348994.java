String home = (String) AccessController.doPrivileged(new PrivilegedAction() 
 {
      public Object run() 
      {
     return System.getProperty("user.home");
      }
 });