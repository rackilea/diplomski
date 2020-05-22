public class ListChecker implements Runnable {
  // Number of threads.
  static final int THREADS = 20;
  // The list.
  static final EndLockedList<Integer> list = new EndLockedList<Integer>();
  // My ID
  int id;

  public ListChecker(int id) {
    // Remember my ID.
    this.id = id;
  }

  @Override
  public void run() {
    // My string.
    StringBuilder result = new StringBuilder();
    // Build my string.
    for (int i = 0; i < list.size(); i++) {
      result.append(i).append(",");
    }
    // Add me to the list.
    list.add(id);
    // Unlock the end lock.
    list.unlock();
    System.out.println(id + ": " + result.toString());
  }

  public static void main(String[] args) {
    for (int i = 0; i < THREADS; i++) {
      ListChecker checker = new ListChecker(i + 1);
      new Thread(checker).start();
    }
  }

  private static class EndLockedList<T> extends ArrayList<T> {
    // My lock.
    private final Lock lock = new ReentrantLock();
    // Were we locked?
    private volatile boolean locked = false;

    @Override
    public boolean add(T it) {
      lock.lock();
      try {
        return super.add(it);
      } finally {
        lock.unlock();
      }
    }

    // Special get that locks the list when the last entry is got.
    @Override
    public T get(int i) {
      // Get it.
      T it = super.get(i);
      // If we are at the end.
      if (i == size() - 1) {
        // Speculative lock.
        lock.lock();
        // Still at the end?
        if (i < size() - 1) {
          // Release the lock!
          lock.unlock();
        } else {
          // Remember we were locked.
          locked = true;
          // It is now locked for putting until specifically unlocked.
        }
      }
      // That's the one.
      return it;
    }

    // Unlock.
    void unlock() {
      if (locked) {
        locked = false;
        lock.unlock();
      }
    }
  }
}