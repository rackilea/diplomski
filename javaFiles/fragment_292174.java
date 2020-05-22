public static void main(String[] args) {
    final Object lock = new Object();
    new Thread(new Runnable() {
        @Override
        public void run() {
            synchronized(lock) {
                try {
                    lock.wait();
                    System.out.println("lock released");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }).start();
    System.out.println("before sleep");
    try {
        Thread.sleep(1000);
        System.out.println("before notify");
        synchronized(lock) {
            lock.notify();
        }
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}