import java.awt.*;
import java.awt.geom.Rectangle2D;
import javax.swing.*;

public class FrameTestBase extends JFrame {
    public static void main(String args[]) {
        FrameTestBase t = new FrameTestBase();
        t.add(new JComponent() {
            public void paintComponent(Graphics g) {
                String str = "hello world!";
                Color textColor = Color.WHITE;
                Color bgColor = Color.BLACK;
                int x = 80;
                int y = 50;

                FontMetrics fm = g.getFontMetrics();
                Rectangle2D rect = fm.getStringBounds(str, g);

                g.setColor(bgColor);
                g.fillRect(x,
                           y - fm.getAscent(),
                           (int) rect.getWidth(),
                           (int) rect.getHeight());

                g.setColor(textColor);
                g.drawString(str, x, y);
            }
        });

        t.setDefaultCloseOperation(EXIT_ON_CLOSE);
        t.setSize(400, 200);
        t.setVisible(true);
    }
}