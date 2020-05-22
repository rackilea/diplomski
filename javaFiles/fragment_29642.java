import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Game extends JPanel {
    public static final String RESOURCE_PATH = "image.png";
    private static final int PREF_W = 400;
    private static final int PREF_H = PREF_W;
    private BufferedImage dbimage = null;
    private int imgX = 0;
    private int imgY = 0;

    public Game(BufferedImage dbimage) {
        this.dbimage = dbimage;
    }

    // draw within the paintComponent method, not the paint method
    @Override
    protected void paintComponent(Graphics g) {
        // call the super's method to all painting to chain down the line
        super.paintComponent(g);
        if (dbimage != null) {
            g.drawImage(dbimage, imgX, imgY, this);
        }
    }

    // set the preferred size of the main Game JPanel safely 
    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    private static void createAndShowGui() {
        // get your image as a resource
        URL resource = Game.class.getResource(RESOURCE_PATH);
        BufferedImage img = null;
        try {
            // read in using ImageIO
            img = ImageIO.read(resource);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        // pass image into your Game JPanel
        Game mainPanel = new Game(img);

        // pass the JPanel into a JFrame
        JFrame frame = new JFrame("Game");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);  // and display it
    }

    public static void main(String[] args) {
        // start your Swing GUI in a thread-safe manner
        SwingUtilities.invokeLater(() -> {
            createAndShowGui();
        });
    }
}