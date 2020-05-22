class Windows implements Runnable {
    private int tickets = 1000;
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        for (;;) { // loop forever
            synchronized (this){
                if (this.tickets == 0)
                    break;
                System.out.println(threadName + " is saling " + this.tickets);
                this.tickets--;
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}