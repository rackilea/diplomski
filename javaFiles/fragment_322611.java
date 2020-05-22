import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {

    private final static JFrame frame = new JFrame();
    private final static Panel panel = new Panel();

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                panel.setPreferredSize(new Dimension(1000, 750));
                frame.setContentPane(panel);
                frame.pack();
                frame.setVisible(true);
            }
        });

        while (true) {
            panel.setBackgroundColour(Color.WHITE);
            panel.setBackgroundColour(Color.BLACK);
            panel.repaint();
            try {
                Thread.sleep(40);
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private static class Panel extends JPanel {

        private BufferedImage offScreen = new BufferedImage(1000, 700, BufferedImage.TYPE_INT_ARGB);

        @Override
        protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            graphics.drawImage(offScreen, 0, 0, this);
        }

        public void setBackgroundColour(Color colour) {
            Graphics graphics = offScreen.getGraphics();
            graphics.setColor(colour);
            graphics.fillRect(0, 0, 1000, 700);
            graphics.dispose();
        }

    }

    public static BufferedImage createCompatibleImage(int width, int height, int transparency) {

        BufferedImage image = getGraphicsConfiguration().createCompatibleImage(width, height, transparency);
        image.coerceData(true);
        return image;

    }

    public static GraphicsConfiguration getGraphicsConfiguration() {

        return GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();

    }
}