import javax.swing.*;
import java.awt.*;

public class Test extends JPanel {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.add(new Test());
                frame.setVisible(true);
                frame.pack();
            }
        });
    }

    public Dimension getPreferrdSize() {
        return new Dimension(200, 200);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(10, 10, 150, 40);
    }
}