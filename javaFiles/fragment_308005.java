import java.awt.image.BufferedImage;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Main {

    BufferedImage img;

    public static void main(String[] args) {
        Main main = new Main();
        main.load();
    }

    public void load() {
        try {
            ClassLoader cl = this.getClass().getClassLoader();
            System.out.println("CL:" + cl);
            InputStream url = getClass().getClass().getResourceAsStream("/resources/stackoverflow5.png");
            System.out.println("URL:" + url);
            this.img = ImageIO.read(url); // Null argument exception
            JOptionPane.showMessageDialog(null, new JLabel(new ImageIcon(img)), "With ClassLoader", JOptionPane.PLAIN_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}