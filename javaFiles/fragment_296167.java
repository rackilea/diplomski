public class Loop extends Thread {
    private boolean running;
    private Listener listener;

    public Loop() {
        running = false;
    }

    public void run() {
        while(running) {
            if(listener != null)
                listener.callMethod();
        }
    }

    public void setRunning(boolean b) {
        running = b;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }
}