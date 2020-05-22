class Friend {
   private static final Object lock = new Object();

   public void bow(...) {
     synchronized( lock ) {
        ...
     }
   }

   public void bowback(...) {
     synchronized( lock ) {
        ...
     }
   }

}