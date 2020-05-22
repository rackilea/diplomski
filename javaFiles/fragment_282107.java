import java.awt.*;
import javax.swing.*;

public class FrameTest {
    public static void main(String args[]) {
        JFrame f = new JFrame();
        f.add(new JComponent() {
            public void paintComponent(Graphics g) {

                // Some parameters.
                String text = "Some Label";
                int centerX = 150, centerY = 100;
                int ovalWidth = 200, ovalHeight = 100;

                // Draw oval
                g.setColor(Color.BLUE);
                g.fillOval(centerX-ovalWidth/2, centerY-ovalHeight/2,
                           ovalWidth, ovalHeight);

                // Draw centered text
                FontMetrics fm = g.getFontMetrics();
                double textWidth = fm.getStringBounds(text, g).getWidth();
                g.setColor(Color.WHITE);
                g.drawString(text, (int) (centerX - textWidth/2),
                                   (int) (centerY + fm.getMaxAscent() / 2));

            }
        });

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(300, 300);
        f.setVisible(true);
    }
}