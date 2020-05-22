import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main extends JFrame {

    public static void main(String[] args0) {

        try {
            JFrame frame = new JFrame();
            File imageFile = new File("background.bmp");
            Image i = ImageIO.read(imageFile);
            ImageIcon image = new ImageIcon(i);
            JLabel imageLabel = new JLabel(image);
            frame.add(imageLabel);
            frame.setLayout(null);
            imageLabel.setLocation(0, 0);
            imageLabel.setSize(1000, 750);
            imageLabel.setVisible(true);
            frame.setVisible(true);
            frame.setSize(1000, 750);
            frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}