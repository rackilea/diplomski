static Thread innerThread;
static ArrayList lastList = new ArrayList<>();

public static void main(String[] args) {
  System.out.println("Thread main: started.");

  Thread thread = new Thread(new Runnable() {
    @Override
    public void run() {
      System.out.println("Thread thread: started.");

      innerThread = new Thread(new Runnable() {
        public void run() {
          System.out.println("Thread innerThread: started.");
          try {
            System.out.println("Thread innerThread: sleeping for 1 second.");
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          lastList.add("test");
          System.out.println("Thread innerThread: value added to the lastList");
          System.out.println("Thread innerThread: ended.");
        }
      });
      innerThread.start();
      System.out.println("Thread thread: ended.");
    }
  });

  thread.start();
  try {
    thread.join(); // to be sure that thread is finished - innerTread is initialized
    innerThread.join(); // to be sure that innerTread is finished - lastList is updated

    System.out.println("Thread main: lastList.size() = " + lastList.size()); // Size: 1
  } catch (Exception e){
    e.printStackTrace();
  }
  System.out.println("Thread main: ended.");
}