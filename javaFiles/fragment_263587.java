import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Drawing {
    JFrame frame = new JFrame();

    public Drawing() {
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(new Panel());
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Drawing();
            }
        });
    }

    class Panel extends JPanel {
        BufferedImage image = null;

        Panel() {
            try {
                image = ImageIO.read(new File("path-to-your-image"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, this);
        }

        @Override
        public Dimension getPreferredSize() {
            // Panel will be sizes based on dimensions of image
            return new Dimension(image.getWidth(), image.getHeight());
        }
    }
}