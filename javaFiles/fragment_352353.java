final ReentrantLock lock = new ReentrantLock();
for (int i = 0; i < 5; i++) {
    final int finalI = i;
    new Thread(new Runnable() {
        @Override
        public void run() {
            for (int j = 0; j < 5; j++) {
                lock.lock();
                System.out.println("locked by " + finalI);
                lock.unlock();
            }
        }
    }).start();
}