public final class SingleBlockingQueue<T> {
    private final Object lock = new Object();
    private T value;
    private boolean present = false;

    public void offer(T value) throws InterruptedException {
      synchronized (lock) {
        while (present)
          lock.wait();
        this.value = value;
        present = true;
        lock.notifyAll();
      }
    }

    public T take() throws InterruptedException {
      synchronized (lock) {
        while (!present)
          lock.wait();
        T returnValue = value;
        value = null; // Should release reference
        present = false;
        lock.notifyAll();
        return returnValue;
      }
    }
  }