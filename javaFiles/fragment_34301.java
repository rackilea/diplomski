import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog.ModalityType;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

public class DialogEg {
    // path to example image used as "game" background
    private static final String IMG_PATH = "https://upload.wikimedia.org/"
            + "wikipedia/commons/7/76/Jump_%27n_Bump.png";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }

    private static void createAndShowGui() {
        // get the "game" background image, or exit if fail
        BufferedImage img = null;
        try {
            URL imgUrl = new URL(IMG_PATH);
            img = ImageIO.read(imgUrl);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        // pass "game" image into main JPanel so that it will be drawn
        DeMainPanel mainPanel = new DeMainPanel(img);
        JFrame frame = new JFrame("Dialog Example");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(mainPanel); // add main JPanel to JFrame
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
}