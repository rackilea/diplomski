import java.awt.event.*;
import javax.swing.*;

public class PruebaEvento {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Frame frame = new Frame();
            Panel panel = new Panel();
            frame.add(panel);
            Controller c = new Controller(panel);

            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
}