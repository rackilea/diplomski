static volatile int sharedVar;

public static void main(String[] args) throws Exception {
  final long startTime = System.currentTimeMillis();
  final long[] aTimes = new long[5], bTimes = new long[5];
  final Thread
    a = new Thread() { public void run() {
      for (int i = 0; i < 5; i++) {
        sharedVar = 1;
        aTimes[i] = System.currentTimeMillis()-startTime;
        briefPause();
      }
    }},
    b = new Thread() { public void run() {
      for (int i = 0; i < 5; i++) {
        bTimes[i] = sharedVar == 0?
            System.currentTimeMillis()-startTime : -1;
        briefPause();
      }
    }};
  a.start(); b.start();
  a.join(); b.join();
  System.out.println("Thread A wrote 1 at: " + Arrays.toString(aTimes));
  System.out.println("Thread B read 0 at: " + Arrays.toString(bTimes));
}
static void briefPause() {
  try { Thread.sleep(3); }
  catch (InterruptedException e) {throw new RuntimeException(e);}
}