import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class ImageManipulationDemo {
    private static BufferedImage ORIGINAL;
    private static BufferedImage ALTERED;
    private static final GraphicsConfiguration config = 
        GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();

    public static void main(String[] args) {
        try {
            loadImages();

            SwingUtilities.invokeLater(new Runnable(){
                @Override
                public void run() {
                    createAndShowGUI();             
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadImages() throws IOException {
        ORIGINAL = ImageIO.read(
                ImageManipulationDemo.class.getResource("../resources/whitefro1.jpg"));
        ALTERED = config.createCompatibleImage(
                ORIGINAL.getWidth(), 
                ORIGINAL.getHeight() + 20);
        Graphics2D g2 = ALTERED.createGraphics();
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, ALTERED.getWidth(), 20);
        g2.drawImage(ORIGINAL, 0, 20, null);
        g2.dispose();

        // Save image
        ImageIO.write(ALTERED, "PNG", new File("alteredImage.png"));
    }

    private static void createAndShowGUI() {
        final JFrame frame = new JFrame("Image Manipulation Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.BLUE.darker());
        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(new JLabel(new ImageIcon(ORIGINAL)));
        frame.getContentPane().add(new JLabel(new ImageIcon(ALTERED)));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}