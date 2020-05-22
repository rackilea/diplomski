class Abc extends Thread {
    @Override
    public synchronized void start() {
        super.start();

        Thread currentThread = Thread.currentThread();
        System.out.printf("Start, Which Thread: %s, %d%n", 
                currentThread.getName(), 
                currentThread.getId());

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread" + " " + i);
        }
    }

    @Override
    public void run() {
        super.run();

        Thread currentThread = Thread.currentThread();
        System.out.printf("Run, Which Thread: %s, %d%n", 
                currentThread.getName(), 
                currentThread.getId());
    }
}