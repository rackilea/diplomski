public static void main(String[] args) {

    Object lock = new Object();
    Timer timer = new Timer();
    timer.schedule(new MyTimerTask(lock), 3000);

    synchronized (lock) {
        try {
            lock.wait();
        } catch (InterruptedException ex) {
        }
    }

    //execute this code after timer finished
    System.out.println("finish");
}

private static class MyTimerTask extends TimerTask {

    private Object lock;

    public MyTimerTask(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        System.out.println("inside timer");
        synchronized (lock) {
            lock.notifyAll();
        }
    }

}