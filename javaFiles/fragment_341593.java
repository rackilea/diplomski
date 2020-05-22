private Thread taskThread;

@Override
public void run() {
    taskThread = Thread.currentThread();
    System.out.println("going to sleep at: " + new Date());
    doSomeWorks();
    System.out.println("returned back at: " + new Date());
}

private void dosomeWorks() {
    for (int i = 0; !Thread.interrupted() && i < 10; ++i) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

...
mTimer.cancel();
timerTask.taskThread.interrupt();
...