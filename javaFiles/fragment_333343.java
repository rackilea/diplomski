Thread[] threads = new Thread[3];
for (int i = 0; i < threads.length; i++) {
  final int j = i;
  threads[i] = new Thread(new Runnable() {
    public void run() {
      // some code to run in parallel
      System.out.println(j);
    }
  });
  threads[i].start();
}