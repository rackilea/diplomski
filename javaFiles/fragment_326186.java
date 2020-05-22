public static void main(final String[] args) throws Exception {
    final BlockingQueue<Runnable> blockingQueue = new LinkedBlockingDeque<>();
    final Thread t = new Thread(new Runnable() {

        @Override
        public void run() {
            while (true) {
                try {
                    blockingQueue.take().run();
                } catch (InterruptedException ex) {
                    return;
                }
            }
        }
    });
    t.start();
    blockingQueue.add(new Runnable() {

        @Override
        public void run() {
            System.out.println("Task 1");
        }
    });
    blockingQueue.add(new Runnable() {

        @Override
        public void run() {
            System.out.println("Task 2");
        }
    });
}