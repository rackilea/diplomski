public final class SingleBlockingQueue<T> {
    private volatile T value;
    private final Semaphore full = new Semaphore(0);
    private final Semaphore empty = new Semaphore(1);

    public void offer(T value) throws InterruptedException {
      empty.acquire();
      this.value = value;
      full.release();
    }

    public T take() throws InterruptedException {
      full.acquire();
      T returnValue = value;
      value = null; // Should release reference
      empty.release();
      return returnValue;
    }
  }