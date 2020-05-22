public class Foo {
  private static final AtomicInteger liveInstances = new AtomicInteger(0);
  private static final ThreadLocal<Integer> threadLocalLiveInstances = new ThreadLocal<Integer>() {
    @Override protected Integer initialValue() { return 0; }
  }

  // instance initializer (so you won't have problems with multiple constructors or virtual methods called from them):
  {
    liveInstances.incrementAndGet();
    threadLocalLiveInstances.set(threadLocalLiveInstances.get() + 1);
  }

  public static int getTotalLiveInstances() {
    return liveInstances.get();
  }

  public static int getThreadLocalLiveInstances() {
    return threadLocalLiveInstances.get();
  }

  public static void decrementInstanceCount() {
    threadLocalLiveInstances.set(threadLocalLiveInstances.get() - 1);
    liveInstaces.decrementAndGet();
  }

  // ... rest of the code of the class ...
}

class FooCountingThreadFactory implements ThreadFactory {
  public Thread newThread(final Runnable r) {
    return new Thread(new Runnable() {
      @Override public void run() {
        try {
          r.run();
        } finally {
          while (Foo.getThreadLocalLiveInstances() > 0) {
            Foo.decrementInstanceCount();
          }
        }
      }
    });
  }
}