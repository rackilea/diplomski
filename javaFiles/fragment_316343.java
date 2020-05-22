import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTextField;


public class TextFieldTest {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setLayout(new BorderLayout());
        JTextField tf = new JTextField();
        f.getContentPane().add(BorderLayout.EAST, tf);
        f.pack();
        f.setVisible(true);
    }
}