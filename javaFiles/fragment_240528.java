public class Test {

  public static boolean running = false;

  public synchronized void runner() {
    if(!running) {
      running = true;
      System.out.println("I'm running!");
      new Thread() {
        public void run() {
          for(int i=0; i<10000; i++) {} // Waste some time
          running = false; // This is only changed once the thread completes its execution.
        }
      }.start();
    } else {
      System.out.println("Already running.");
    }
  }

  public static void main(String[] args) {
    Test tester = new Test();
    tester.runner();
    tester.runner(); // The loop inside the Thread should still be running so this should fail.
    for(int i=0; i<20000; i++) {} // Waste even more time.
    tester.runner(); // The loop inside the Thread should be done so this will work.
  }
}