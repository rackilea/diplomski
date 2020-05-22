class Socket{
    private void startThreads() {
          new Thread(new Th1()).start();
          new Thread(new Th2()).start();

    }
}
class Th1 implements Runnable {
    @Override
    public void run() {
        fucn1();
    }
}
class Th2 implements Runnable {
    @Override
    public void run() {
        fucn2();
    }
}