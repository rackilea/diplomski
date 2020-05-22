import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Main implements Runnable, KeyListener {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::initGUI);
    }

    private static void initGUI() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JLabel("Press SPACE key for printing primes"));
        frame.pack();
        frame.setLocationRelativeTo(null); // center on screen
        frame.setVisible(true);

        Main main = new Main();
        frame.addKeyListener(main);
        Thread thread = new Thread(main);
        thread.start();
    }

    private boolean spaceKeyPressed;

    private boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    @Override
    public void run() {
        for (int n = 2; /**/; n++) {
            while (!spaceKeyPressed) {
                synchronized (this) {
                    try {
                        wait(); // waits until notify()
                    } catch (InterruptedException e) {
                        // do nothing
                    }
                }
            }
            if (isPrime(n)) {
                System.out.println(n);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // do nothing
    }

    @Override
    public synchronized void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            spaceKeyPressed = true;
            notifyAll(); // cause wait() to finish
        }
    }

    @Override
    public synchronized void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            spaceKeyPressed = false;
            notifyAll(); // cause wait() to finish
        }
    }
}