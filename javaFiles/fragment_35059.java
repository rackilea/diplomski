public class NowImFeelingZombified {
  static Object logWriter = new Object();

public static void main(String[] args) {
    final NowImFeelingZombified zombie1 = new NowImFeelingZombified();
    final NowImFeelingZombified zombie2 = new NowImFeelingZombified();

    Thread t1 = new Thread("zombie1 ") {
        @Override
        public void run() {
            zombie1.syncedMethod();
        }
    };
    Thread t2 = new Thread("zombie2 ") {
        @Override
        public void run() {
            zombie2.syncedMethod();
        }
    };
    t1.start();
    t2.start();
}

private synchronized void syncedMethod() {
    try {
        System.out.println(Thread.currentThread().getName() + logWriter.toString());

        Thread.sleep(2000L);

        System.out.println(Thread.currentThread().getName() + logWriter.toString());

        logWriter = null;
    }
    catch (InterruptedException e) {
    }
  }
}