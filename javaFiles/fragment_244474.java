Runnable cleaner = new Runnable() {
public void run() { /* remove expired objects here */ 
     //Using get method check whether object is expired 
   }
};
Executors.newScheduledThreadPool(1)
       .scheduleWithFixedDelay(cleaner, 0, 30, TimeUnit.SECONDS);