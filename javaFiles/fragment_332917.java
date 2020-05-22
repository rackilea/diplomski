import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PaintPercentImage extends JPanel {

    private static final int GLASS_WIDTH = 75;
    private static final int GLASS_X = 75;
    private static final int HORIZON = 210;
    private static final int GLASS_Y_TOP = 10;
    private static final int GLASS_HEIGHT = HORIZON - GLASS_Y_TOP;

    private double glassY = GLASS_Y_TOP;
    private double rectHeight = GLASS_HEIGHT;
    private BufferedImage image;
    private Rectangle2D rect;
    private int imageWidth;
    private int imageHeight;

    private static JSpinner spinner;

    public PaintPercentImage() {
        try {
            image = ImageIO.read(new URL("http://i.stack.imgur.com/G4IEu.jpg"));
            imageWidth = image.getWidth();
            imageHeight = image.getHeight();
            System.out.println(imageHeight);
        } catch (IOException e) {
            e.printStackTrace();
        }

        rect = new Rectangle2D.Double(GLASS_X, glassY, GLASS_WIDTH, rectHeight);
        spinner = createSpinner();
    }

    private JSpinner createSpinner() {
        final JSpinner spinner = new JSpinner();
        SpinnerNumberModel model = new SpinnerNumberModel(100, 0, 100, 1);
        spinner.setModel(model);
        spinner.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                int value = (Integer) spinner.getModel().getValue();
                calculateGlassValues(value);
                System.out.println(value);
                repaint();
            }

        });
        return spinner;
    }

    private void calculateGlassValues(int value) {
        rectHeight = GLASS_HEIGHT * (value / 100.0);
        glassY = HORIZON - rectHeight;
        rect.setRect(GLASS_X, glassY, GLASS_WIDTH, rectHeight);
        System.out.print(rect.getBounds());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(image, 0, 0, imageWidth, imageHeight, this);
        g2.setPaint(Color.YELLOW);
        g2.fill(rect);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(imageWidth, imageHeight);
    }

    public static void showGui() {
        JFrame frame = new JFrame();
        frame.add(new PaintPercentImage());
        frame.add(spinner, BorderLayout.NORTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                showGui();
            }
        });
    }
}