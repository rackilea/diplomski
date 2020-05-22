public void run() {
   try {
      while(true) {
         ...
      }
   } catch (final Throwable t) {
      System.out.println("I never print this.");
   } finally {
      System.out.println("I always print this.");
   }
}