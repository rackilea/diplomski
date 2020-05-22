package stackoverflowtests;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Skeleton extends JPanel {

    private BufferedImage img = null;

    public Skeleton() {
        setSize(1000, 500);
        try {
            img = ImageIO.read(new File("index.jpg"));
        } catch (IOException e) {
            System.out.println("Loading failed.");
        }
    }

    public void paint(Graphics g) {
        g.drawImage(img, 50, 50, null);
    }

}