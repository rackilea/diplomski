import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

/**
 * @author Savvas Dalkitsis
 */
public class Test1 {

    public static void main(String[] args) {
        JFrame f = new JFrame("Test");
        JLabel c = new JLabel("Hello");
        Border b = BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(2, 0, 2, 0, Color.black),
                BorderFactory.createEmptyBorder(0, 100, 0, 0));
        c.setBorder(b);
        f.getContentPane().add(c);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }

}