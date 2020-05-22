public void run() {
   while(!Thread.currentThread().interrupted()) {
       doWork();     
       callMethodWhichIgnoresInterrupted();
   }
}