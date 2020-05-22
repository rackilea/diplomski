class MyClass {
      private static volatile Resource resource;
      private static final Object LOCK = new Object();

      public static Resource getInstance() {
            if(resource == null) { 
                synchronized(LOCK) { // Add a synch block
                    if(resource == null) { // verify some other synch block didn't
                                           // write a resource yet...
                        resource = new Resource();
                    }
                }
            }
            return resource;
      }
 }