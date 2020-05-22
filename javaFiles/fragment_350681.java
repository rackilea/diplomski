public class Tester {
  // Apologies, I'm too lazy to create two separate files
  static public class Test implements Runnable {

    private void doSomework() {
      System.out.print(
          "do some work on Thread: "
         +Thread.currentThread().getId()
      );
      try {
        Thread.sleep(500); // just to simulate a load
      }
      catch(InterruptedException e) {
        // ignore
      }
    }

    public void run() {
      do {
        boolean shouldIWait=true;
        synchronized(Tester.lockingObj) {
          Boolean flag=Tester.waitConditions.get(Thread.currentThread().getId());
          if(null!=flag) {
            shouldIWait=flag.booleanValue();
          } // if null, the tester started me before creating my flag. I'll wait
          if(shouldIWait) {
            // I need to wait for someone to wake me
            try {
              Tester.lockingObj.wait();
            } catch (InterruptedException e) {
              e.printStackTrace();
              // well, I'm interrupted, so I'll do no more work.
              break;
            }
          }
        }
        if(false==shouldIWait) {
          // waiting no more
          this.doSomework();
        }
      } while(true);
    }

  }

  public static Object lockingObj=new Object();

  public static TreeMap<Long, Boolean> waitConditions=
      new TreeMap<Long, Boolean>();

  public static void main(String[] args) {
    Thread nThread = new Thread(new Test());
    Thread nThread1 = new Thread(new Test());
    Thread nThread2 = new Thread(new Test());
    Thread nThread3 = new Thread(new Test());

    // when starting, all threads will be waiting
    waitConditions.put(nThread.getId(), true);
    waitConditions.put(nThread.getId(), true);
    waitConditions.put(nThread.getId(), true);
    waitConditions.put(nThread.getId(), true);

    nThread2.start();
    nThread1.start();
    nThread.start();
    nThread3.start();

    Long id = nThread.getId();
    synchronized (lockingObj) {  // when notified, all thread should wakeup
      waitConditions.put(id, false);  // but only nThread will be allowed to doSomeWork
      lockingObj.notifyAll(); // wake up all the threads. 
                              // Those not allowed, will go into 
                              // back waiting
    }

    try {
      // just to have the main thread still running for a while
      Thread.sleep(3000);
    } catch (InterruptedException e) {
    }
    // maybe we want to switch of nThread and start another?
    synchronized (lockingObj) {
      waitConditions.put(id, true);
      waitConditions.put(nThread1.getId(), false);
      lockingObj.notifyAll();
    }
    try {
      // just to have the main thread still running for a while
      Thread.sleep(3000);
    } catch (InterruptedException e) {
    }

  }  
}