import java.awt.Color;
import java.awt.Font;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;

import colormixer.KMColorUtils;

public class Byta {

    public static void main(String[] args) throws IOException {
        Font font = new Font("Arial", Font.BOLD, 12);

        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Hello World");
        label.setFont(font);

        Color customColor = KMColorUtils.mix(Color.CYAN, Color.YELLOW);
        label.setForeground(customColor);

        frame.getContentPane().add(label);

        frame.pack();
        frame.setVisible(true);
    }

}