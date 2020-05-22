import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(600, 400);

        JPanel panel = new MyRectangleJPanel(); // changed this line
        frame.add(panel);

        // Graphics g = panel.getGraphics();
        // g.setColor(Color.BLUE);
        // g.fillRect(0, 0, 100, 100);

        frame.validate(); // because you added panel after setVisible was called
        frame.repaint(); // because you added panel after setVisible was called
    }
}

/* A JPanel that overrides the paintComponent() method and draws a rectangle */
class MyRectangleJPanel extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, 100, 100);
    }
}