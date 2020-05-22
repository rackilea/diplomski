import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class SierpTest {
    public static final int BI_WIDTH = 630;
    public static final int BI_HEIGHT = 580;

    public static void main(String[] args) {

        // do this stuff off the swing event thread
        final BufferedImage sierpImg = new BufferedImage(BI_WIDTH, BI_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        Graphics g = sierpImg.getGraphics();

        // draw triangle with g here

        g.dispose(); // always dispose of any Graphics you create yourself

        // do this on the Swing event thread
        SwingUtilities.invokeLater(() -> {
            SierpPanel sierpPanel = new SierpPanel(sierpImg); // pass in image
            JFrame frame = new JFrame("Siep Frame");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(sierpPanel);
            frame.pack(); // size it to the size of the JPanel
            frame.setLocationRelativeTo(null); // center it
            frame.setVisible(true);
        });
    }
}

class SierpPanel extends JPanel {
    private BufferedImage img = null;

    public SierpPanel(BufferedImage img) {
        this.img = img;
    }

    // so that JPanel sizes itself with the image
    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet() || img == null) {
            return super.getPreferredSize();
        }
        return new Dimension(img.getWidth(), img.getHeight());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (img != null) {
            g.drawImage(img, 0, 0, this);
        }
    }
}