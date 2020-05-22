class MyThreadPool implements java.util.concurrent.Executor 
{
    private final java.util.concurrent.BlockingQueue<Runnable> queue;

    public MyThreadPool(int numThreads) {
        queue = new java.util.concurrent.LinkedBlockingQueue<>();
        for (int i=0 ; i<numThreads ; i++) {
            new Thread(new Runnable(){
                @Override
                public void run() {
                    while(true) {
                        queue.take().run();
                    }
                }
            }).start();
        }
    }

    @Override
    public void execute(Runnable command) {
        queue.put(command);
    }
}