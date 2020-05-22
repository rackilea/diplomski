class Handeler {
   private Thread thread;
   .....
   @SuppressWarnings("deprecation")
   void stopThread() {
      if(thread!=null && thread.isAlive()) {                 
            thread.stop();
      }
   }
}