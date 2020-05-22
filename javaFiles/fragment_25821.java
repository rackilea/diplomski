public class GameThread implements Runnable {
    private Thread runThread;
    private boolean running = false;
    private boolean paused = false;
    public GameThread() {
    }

    public void start() {
        running = true;
        paused = false;
        if(runThread == null || !runThread.isAlive())
            runThread = new Thread(this);
        else if(runThread.isAlive())
            throw new IllegalStateException("Thread already started.");
        runThread.start();
    }

    public void stop() {
        if(runThread == null)
            throw new IllegalStateException("Thread not started.");
        synchronized (runThread) {
            try {
                running = false;
                runThread.notify();
                runThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void pause() {
        if(runThread == null)
            throw new IllegalStateException("Thread not started.");
        synchronized (runThread) {
            paused = true;
        }
    }

    public void resume() {
        if(runThread == null)
            throw new IllegalStateException("Thread not started.");
        synchronized (runThread) {
            paused = false;
            runThread.notify();
        }
    }

    public void run() {
        long sleep = 0, before;
        while(running) {
            // get the time before we do our game logic
            before = System.currentTimeMillis();
            // move player and do all game logic
            try {
                // sleep for 100 - how long it took us to do our game logic
                sleep = 100-(System.currentTimeMillis()-before);
                Thread.sleep(sleep > 0 ? sleep : 0);
            } catch (InterruptedException ex) {
            }
            synchronized (runThread) {
                if(paused) {
                    try {
                        runThread.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        paused = false;
    }
}