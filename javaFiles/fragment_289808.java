import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                try {
                    JFrame frame = new JFrame("Testing");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.add(new TestPane());
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (IOException iOException) {
                    iOException.printStackTrace();
                }
            }
        });
    }

    public class TestPane extends JPanel {

        private BufferedImage master;
        private BufferedImage rotated;

        public TestPane() throws IOException {
            master = ImageIO.read(new File("/Volumes/Disk02/Dropbox/MegaTokyo/issue142.jpg"));
            rotated = new BufferedImage(master.getWidth(), master.getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = rotated.createGraphics();
            AffineTransform at = new AffineTransform();
            at.rotate(Math.PI / 2, master.getWidth() / 2, master.getHeight() / 2);
            g2d.setTransform(at);
            g2d.drawImage(master, 0, 0, this);
            g2d.dispose();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(master.getWidth() * 2, master.getHeight());
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            int x = (getWidth() - (master.getWidth() * 2)) / 2;
            int y = (getHeight() - master.getHeight()) / 2;
            g2d.drawImage(master, x, y, this);
            g2d.drawImage(rotated, x + master.getWidth(), y, this);
            g2d.dispose();
        }

    }

}