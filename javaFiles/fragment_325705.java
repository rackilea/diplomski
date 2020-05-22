import java.awt.Color;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UnsupportedLookAndFeelException;

public class TestAnimation {
    private static final int NB_OF_IMAGES = 50;
    private static final int NB_OF_IMAGES_PER_SECOND = 25;
    private static final int WIDTH = 300;
    private static final int HEIGHT = 300;

    protected void initUI() {
        final JFrame frame = new JFrame(TestAnimation.class.getSimpleName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        // the label on which I will set images
        final JLabel label = new JLabel();
        // By adding to the frame, it is set as the central component of the 
        // BorderLayout of the JFrame. Eventually, the label will have the size of the content pane
        frame.add(label);
        frame.setSize(WIDTH, HEIGHT);
        // Creating a list of images (just for demo purposes)
        final List<Image> images = new ArrayList<Image>(NB_OF_IMAGES);
        for (int i = 0; i < NB_OF_IMAGES; i++) {
            CirclePanel circle = new CirclePanel(WIDTH / 2, WIDTH / 2, 2 * WIDTH * (NB_OF_IMAGES / 2 - Math.abs(i - NB_OF_IMAGES / 2))
                    / NB_OF_IMAGES);
            circle.setSize(WIDTH, HEIGHT);
            BufferedImage image = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration()
                    .createCompatibleImage(WIDTH, HEIGHT, BufferedImage.TRANSLUCENT);
            circle.print(image.getGraphics());
            images.add(image);
        }
        // Here is the timer logic
        Timer t = new Timer(1000 / NB_OF_IMAGES_PER_SECOND, new ActionListener() {
            private int i = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (i == images.size()) {
                    i = 0;
                }
                label.setIcon(new ImageIcon(images.get(i++)));
            }
        });
        frame.setVisible(true);
        t.start();
    }

    // Simple class that draws a red circle centered on x,y and given radius
    public static class CirclePanel extends JPanel {

        private int x;
        private int y;
        private int radius;

        public CirclePanel(int x, int y, int radius) {
            super();
            this.x = x;
            this.y = y;
            this.radius = radius;
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.RED);
            g.drawArc(x - radius / 2, y - radius / 2, radius, radius, 0, 360);
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException,
            UnsupportedLookAndFeelException {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new TestAnimation().initUI();
            }
        });
    }
}