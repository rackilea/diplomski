Thread myThread = new Thread()  {
    @Override
    public void run() {
        while (!this.isInterrupted()) {
            System.out.println("I'm working");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                //We would like also exit from the thread
                return;
            }
        }
    }
};