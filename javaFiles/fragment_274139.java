import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class MyBoard extends JPanel {
    private static final String IMG_PATH = "http://ecx.images-amazon.com/"
            + "images/I/81oC5pYhh2L._SL1500_.jpg";

    // scaling constants
    private static final int IMG_WIDTH = 1024;
    private static final int IMG_HEIGHT = IMG_WIDTH;

    // original and scaled image variables
    private BufferedImage initialImg;
    private Image scaledImg;

    public MyBoard() throws IOException {
        URL url = new URL(IMG_PATH);
        initialImg = ImageIO.read(url); // read in original image

        // and scale it *once* and store in variable. Can even discard original
        // if you wish
        scaledImg = initialImg.getScaledInstance(IMG_WIDTH, IMG_HEIGHT,
                Image.SCALE_SMOOTH);
    }

    // override paintComponent, not paint
    @Override   // and don't forget the @Override annotation
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // call the super's painting method

        // just to be safe -- check that it's not null first
        if (scaledImg != null) {
            // use this as a parameter to avoid drawing an image before it's
            // ready
            g.drawImage(scaledImg, 0, 0, this);
        }
    }

    // so our GUI is sized the same as the image
    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet() || scaledImg == null) {
            return super.getPreferredSize();
        }
        int w = scaledImg.getWidth(this);
        int h = scaledImg.getHeight(this);
        return new Dimension(w, h);
    }

    private static void createAndShowGui() {
        MyBoard mainPanel = null;
        try {
            mainPanel = new MyBoard();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        JFrame frame = new JFrame("My Board");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}