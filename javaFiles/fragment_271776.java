import java.awt.image.BufferedImage;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import javax.imageio.ImageIO;

public class WorldMapScroll extends JPanel {

    private final BufferedImage image;
    private int imageCoordX = 0;
    private int step = 5; // Travels east. Use negative for west

    public WorldMapScroll() throws Exception {
        setBackground(new Color(0, 0, 86));
        URL url = new URL("https://i.stack.imgur.com/P59NF.png");
        image = ImageIO.read(url);
        setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));

        ActionListener animListener = (ActionEvent e) -> {
            imageCoordX = imageCoordX + step;
            repaint();
        };
        Timer timer = new Timer(60, animListener);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int w = image.getWidth();
        g.drawImage(image, imageCoordX % w, 0, this);
        System.out.println(imageCoordX);

        if (step>0) {
            g.drawImage(image, (imageCoordX%w)-image.getWidth(), 0, this);
        } else {
            g.drawImage(image, (imageCoordX%w)+image.getWidth(), 0, this);
        }
    }

    public static void main(String[] args) {
        Runnable r = () -> {
            JFrame f = new JFrame("Animation of World Map");
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            try {
                f.add(new WorldMapScroll());
                f.setResizable(false);
                f.pack();
                f.setLocationByPlatform(true);
                f.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
        SwingUtilities.invokeLater(r);
    }
}