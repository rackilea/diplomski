import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class Main {

    public static int WIDTH = 1000;
    public static int HEIGHT = 368;

    public static JFrame window = new JFrame();

    public static void main(String[] args) {
        CreateWindow();
    }

    public static void CreateWindow() {
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setSize(WIDTH, HEIGHT);
        BackgroundImage();
        window.pack();
        window.setVisible(true);
    }

    public static void BackgroundImage() {
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\SamBr\\Pictures\\image.png");
        ImageIcon scaledImage = new ImageIcon(
                imageIcon.getImage().getScaledInstance(WIDTH, HEIGHT, Image.SCALE_SMOOTH));
        JLabel label = new JLabel();
        label.setIcon(scaledImage);
        window.add(label);
    }

}