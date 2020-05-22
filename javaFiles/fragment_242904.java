import java.awt.*;
import javax.swing.*;

public class Example {
    public static void main(String args[]) {
        JFrame frame = new JFrame();
        JMenuBar menubar = new JMenuBar();
        JLabel label = new JLabel("Hello World");
        menubar.setLayout(new BorderLayout());
        menubar.add(label, BorderLayout.EAST);
        frame.setLayout(new BorderLayout());
        frame.add(menubar, BorderLayout.PAGE_START);
        frame.setMinimumSize(new Dimension(200, 100));
        frame.setVisible(true);
    }
}