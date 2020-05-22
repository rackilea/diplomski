import javax.swing.*;
import java.awt.*;

public class Component extends JComponent  {
    static final int cellWidth = 7;
    static final int cellHeight = 7;
    static final int borderThickness = 1;

    @Override
    protected void paintComponent(Graphics g) {
        // Background:
        super.paintComponent(g);

        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 5; j++) {
                g.setColor(Color.BLACK);
                g.fillRect(i * cellWidth, j * cellHeight, cellWidth, cellHeight);

                g.setColor(Color.CYAN);
                g.fillRect(i * cellWidth + borderThickness, j * cellHeight + borderThickness,
                           cellWidth - 2 * borderThickness, cellHeight - 2 * borderThickness);
            }
        }

        g.setColor(Color.BLACK);
    }

    public static void main(String[] args) {
        Component component = new Component();

        JFrame f = new JFrame("Test");
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setContentPane(component);
        f.setSize(500, 500);
        f.setVisible(true);
    }
}