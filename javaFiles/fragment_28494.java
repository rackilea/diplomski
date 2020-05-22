public static volatile BlockingQueue<helpRequest> helpQueue;

public void createQueue() {
   // make sure createQueue() is called at the very beginning of your app,
   // somewhere in main()
   helpQueue = new ArrayBlockingQueue...
}