class ThreadTask implements Runnable {

     private int state; // example of private state

     public ThreadTask(int state) {
        this.state = state;
     }

     public void run() {
        // task code
     }
}