class MyRunnable implements Runnable {
    @Override
    public void run() {
       int Runs = 0;
       int[][] Mean10Runs = new int[10][10000];
    // ...

new Thread(new MyRunnable()).start();