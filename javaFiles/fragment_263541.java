class Main {
    public static void main() throws Exception {
        final long timeout_ms = TimeUnit.MINUTES.toMillis(60);
        //Store the main thread ref. so the interruption task can use it
        final Thread me = Thread.currentThread();

        new Thread(){
            @Override
            public void run(){
                // If the timeout happens, or this thread is interrupted
                // due to VM termination etc.) interrupt the main thread.
                try{
                      Thread.sleep(timeout_ms);
                }catch(InterruptedException e){
                      //see finally block
                }finally{
                      me.interrupt();
                }
            }
        }.start();

        // Executing the game in the main thread.
        new Game().run();
    }
}