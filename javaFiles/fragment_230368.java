private static Map <String, FutureLock> results =
        new HashMap <String, FutureLock>();
  ...
  Object lock = new Object();
  Future<Object> future = taskExecutor.submit(new MyCallable(id, lock));
  results.put(id, new FutureLock(future, lock));
  ...

  public class FutureLock {
      private Future<Object> future;
      private Object lock;
      public FutureLock(Future<Object> future, Object lock) {
         this.future = future;
         this.lock = lock;
      }
      public void notify() {
         synchronized (lock) {
            lock.notify();
         }
      }
      public Object get() throws Exception {
         return future.get();
      }
  }

  public class MyCallable {
     private Object lock;
     public MyCallable(String id, Object lock) {
         this.lock = lock;
         ...
     }
  }