import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestAntiAliasingPanel extends JPanel {

    private final RenderingHints rh;

    private TestAntiAliasingPanel(RenderingHints rh) {
        this.rh = rh;
    }

    @Override
    public void paint(Graphics g) {
        BufferedImage bufferedImage = new BufferedImage(400, 400, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = (Graphics2D)bufferedImage.getGraphics();
        g2.setRenderingHints(rh);
        g2.setColor(Color.BLUE);
        g2.fillOval(50, 50, 300, 300);
        g.drawImage(bufferedImage, 50, 50, this);
    }

    public static void main(String[] args) {
        createFrameWithAntiAliasingOption(false);
        createFrameWithAntiAliasingOption(true);
    }

    private static void createFrameWithAntiAliasingOption(boolean antiAliasingOption) {
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                antiAliasingOption ? RenderingHints.VALUE_ANTIALIAS_ON :
                RenderingHints.VALUE_ANTIALIAS_OFF);
        JFrame frame = new JFrame();
        frame.getContentPane().add(new TestAntiAliasingPanel(rh));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}