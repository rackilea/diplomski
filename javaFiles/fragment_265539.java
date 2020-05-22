import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

public class Test extends Canvas implements Runnable {

    private static final long serialVersionUID = 1L;

    public static int WIDTH = 200;
    public static int HEIGHT = 200;

    private Thread thread;
    private boolean running = false;

    public Test() {
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIDTH, HEIGHT);
    }

    public synchronized void start() {
        running = true;
        thread = new Thread(this, "Display");
        thread.start();

    }

    public synchronized void stop() {
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        while (running) {
            update();
            render();

            // Control frame rate
            try {
                Thread.sleep(5);
            } catch (InterruptedException ex) {
            }
        }

    }

    public void update() {
        // Make changes to the model which need to be painted
    }

    public void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }

        do {
            do {
                Graphics2D g = (Graphics2D) bs.getDrawGraphics();
                // You MUST clear the page before painting, bad things
                // happen otherwise
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, getWidth(), getHeight());
                g.setColor(Color.red);
                g.fillRect(10, 50, 50, 70);
                g.dispose();
            } while (bs.contentsRestored());
            bs.show();
        } while (bs.contentsLost());
    }

    public static void main(String[] args) {
        Test test = new Test();
        JFrame frame = new JFrame();
        frame.add(test);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        test.start();

    }

}