Object synchObj = new Object();

 public void run() {
    while (running) {
      synchronized (synchObj) {
         try {
            System.out.println(new Date());
            synchObj.wait(5000);
         } catch (InterruptedException e) {
             // error handling
         }
      }
    }
 }

 public void shutdown() {
    running = false;
    synchronized (synchObj) {
        synchObj.notify();
    }
 }


public static void main(String[] args) throws InterruptedException,
        IOException {
    ThreadTest test = new ThreadTest();
    test.start();
    BufferedReader tReader = new BufferedReader(new InputStreamReader(
            System.in));
    tReader.readLine();
    test.shutdown();
}