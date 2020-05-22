import javax.swing.*;
import java.awt.*;

/**
 * @author Obicere
 */
public class PaintExample {

    public PaintExample() {

        final JFrame frame = new JFrame("Paint Example");
        final MyPanel panel = new MyPanel();

        frame.add(panel);

        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(PaintExample::new);
    }


    public class MyPanel extends JPanel {

        @Override
        public void paintComponent(final Graphics g) {
            super.paintComponent(g);

            g.setColor(Color.YELLOW);
            g.fillOval(0, 0, 50, 50);
            g.setColor(Color.BLACK);
            g.drawOval(0, 0, 50, 50);

            g.drawLine(20, 10, 20, 20);
            g.drawLine(30, 10, 30, 20);

            g.drawArc(15, 15, 20, 20, 180, 180);


            g.drawString("Drawing with swing!", 10, 100);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 400);
        }

    }
}