Thread thread1 = new Thread() {
    @Override
    public void run() {
        System.out.println("thread1 is started, waiting for notify()");

        synchronized (this) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e.getLocalizedMessage());
            }
        }

        System.out.println("waiting is over");
    }
};