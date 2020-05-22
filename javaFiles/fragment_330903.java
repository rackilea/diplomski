import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class SierpTest {
    public static final int BI_WIDTH = 630;
    public static final int BI_HEIGHT = 580;
    private static final int MAX_COUNT = 100000;

    public static void main(String[] args) {

        // do this stuff off the swing event thread
        Point point1 = new Point(10, 550);
        Point point2 = new Point(300, 30);
        Point point3 = new Point(600, 555);
        Point current = point1;
        Point target = current; 
        int count = 0;

        final BufferedImage sierpImg = new BufferedImage(BI_WIDTH, BI_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        Graphics g = sierpImg.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, BI_WIDTH, BI_HEIGHT);
        g.setColor(Color.BLACK);

        while (count <= MAX_COUNT) {
            int choice = (int) (Math.random() * 3);
            switch (choice) {
            case 0:
                target = point1;
                break;
            case 1:
                target = point2;
                break;
            case 2:
                target = point3;
                break;
            default:
                System.exit(0);

            }
            current = midpoint(current, target);
            g.drawLine(current.x, current.y, current.x, current.y);

            count++;
        }

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

    public static Point midpoint(Point a, Point b) {
        return new Point((Math.round(a.x + b.x) / 2), (Math.round(a.y + b.y) / 2));
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