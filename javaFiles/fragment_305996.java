import java.awt.Canvas;
import java.awt.Dimension;
import java.util.concurrent.atomic.AtomicBoolean;

public class Game extends Canvas implements Runnable {

    public static final long serialVersionUID = 1L;

    private Thread thread;
    private AtomicBoolean running = new AtomicBoolean(false);

    public Game() {
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }

    public synchronized void start() {
        running.set(true);
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }
    }

    public synchronized void stop() {
        running.set(false);
        if (thread == null) {
            return;
        }
        try {
            thread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
    }
}