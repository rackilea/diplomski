import org.apache.commons.lang3.time.StopWatch;

public class IdleMonitor implements Runnable {

StopWatch stopWatch;
private final Object monitorObj = new Object();
private boolean isActive;
private long waitTime = 6000; //in milliseconds, put appropriate time to wait

public IdleMonitor() {
    isActive = true;
    stopWatch = new StopWatch();
}

public void reset() { // call this during MouseMoving event
    synchronized (monitorObj) {
        stopWatch.reset();
        monitorObj.notify();
    }
}

public void finish() { // finish idle mointor operation once your operation ends, this will stop the thread
    isActive = false;
    reset();
}

public void start() { // start monitoring
    Thread t = new Thread(IdleMonitor.this);
    t.start();
}

@Override
public void run() {
    synchronized (monitorObj) {
        stopWatch.start();
        while (isActive) {
            try {
                monitorObj.wait(waitTime);
            } catch (InterruptedException ex) {
            }
            long idleTime = stopWatch.getTime();
            System.out.println("Idle time " + idleTime);
            // do something if idle time beyond your expected idle time.
            // you could set isActive=false; if you want to stop monitoring
        }
    }
   }
  }

  }