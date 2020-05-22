import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UnsupportedLookAndFeelException;

public class TestAnimation2 {
    private static final int NB_OF_IMAGES_PER_SECOND = 50;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private Random random = new Random();

    private double dx;
    private double dy;

    private double x = WIDTH / 2;
    private double y = HEIGHT / 2;

    protected void initUI() throws MalformedURLException {
        final JFrame frame = new JFrame(TestAnimation2.class.getSimpleName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        final JLabel label = new JLabel(new ImageIcon(new URL("http://www.lemondedemario.fr/images/dossier/bowser/bowser.png")));
        label.setSize(label.getPreferredSize());
        frame.setMinimumSize(label.getPreferredSize());
        frame.add(label);
        frame.setSize(WIDTH, HEIGHT);
        dx = getNextSpeed();
        dy = getNextSpeed();
        Timer t = new Timer(1000 / NB_OF_IMAGES_PER_SECOND, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                x += dx;
                y += dy;
                if (x + label.getWidth() > frame.getContentPane().getWidth()) {
                    x = frame.getContentPane().getWidth() - label.getWidth();
                    dx = -getNextSpeed();
                } else if (x < 0) {
                    x = 0;
                    dx = getNextSpeed();
                }
                if (y + label.getHeight() > frame.getContentPane().getHeight()) {
                    y = frame.getContentPane().getHeight() - label.getHeight();
                    dy = -getNextSpeed();
                } else if (y < 0) {
                    y = 0;
                    dy = getNextSpeed();
                }
                label.setLocation((int) x, (int) y);

            }
        });
        frame.setVisible(true);
        t.start();
    }

    private double getNextSpeed() {
        return 2 * Math.PI * (0.5 + random.nextDouble());
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException,
            UnsupportedLookAndFeelException {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    new TestAnimation2().initUI();
                } catch (MalformedURLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
    }
}