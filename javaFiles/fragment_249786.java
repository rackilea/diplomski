import java.util.List;
import java.util.Vector;

public class ThreadWork {

  public static void main(String[] args) {

    int count = 5;
    Thread[] threads = new ListThread[count];
    List<String> masterList = new Vector<String>();

    for(int index = 0; index < count; index++) {
      threads[index] = new ListThread(masterList, "Thread " + (index + 1));
      threads[index].start();
    }
    while(isOperationRunning(threads)) {
      // do nothing
    }

    System.out.println("Done!! Print Your List ...");

    for(String item : masterList){
      System.out.println("[" + item + "]");
    }
  }

  private static boolean isOperationRunning(Thread[] threads) {
    boolean running = false;

    for(Thread thread : threads) {
      if(thread.isAlive()) {
        running = true;
        break;
      }
    }
    return running;
  }
}

class ListThread extends Thread {
  private static String items[] = { "A", "B", "C", "D"};
  private List<String> list;
  private String name;

  public ListThread(List<String> masterList, String threadName) {
    list = masterList;
    name = threadName;
  }

  public void run() {
    for(int i = 0; i < items.length;++i) {
      randomWait();
      String data = "Thread [" + name + "][" + items[i] + "]";
      System.out.println( data );
      list.add( data );
    }
  }

  private void randomWait() {
    try {
      Thread.currentThread();
      Thread.sleep((long)(3000 * Math.random()));
    }
    catch (InterruptedException x) {}
  }
}