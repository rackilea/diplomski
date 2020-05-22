public class ListChecker implements Runnable {
  // Number of threads.
  static final int THREADS = 10;
  // The list.
  static final List<Integer> list = new ArrayList<Integer>(THREADS);

  // My ID
  int id;

  public ListChecker(int id) {
    // Remember my ID.
    this.id = id;
  }

  @Override
  public void run() {
    // My string.
    StringBuilder result = new StringBuilder ();
    // Wait for exclusive access to the list.
    synchronized (list) {
      // Build my string.
      for ( Integer i : list ) {
        result.append(i).append(",");
      }
      // Add me to the list.
      list.add(id);
    }
    System.out.println(id + ": " + result.toString());
  }

  public static void main(String[] args) {
    for (int i = 1; i <= THREADS; i++) {
      ListChecker checker = new ListChecker(i);
      new Thread(checker).start();
    }
  }
}