class Runner implements Runnable{
    public volatile boolean RUNNING = false;
        public void run(){

        RUNNING = true;
        try{
            // Your code
        } finally {
            RUNNING = false;
        }
    }
}