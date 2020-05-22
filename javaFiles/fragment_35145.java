import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class TestImage {

    public TestImage() {
        JFrame frame = new JFrame("Test Image");
        frame.add(new NewImagePanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public class NewImagePanel extends JPanel {

        private BufferedImage img;

        public NewImagePanel() {
            try {
                img = ImageIO.read(TestImage.class.getResource("/resources/stackoverflow5.png"));
            } catch (IOException ex) {
                System.out.println("Could not load image");
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(600, 600);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TestImage();
            }
        });
    }
}