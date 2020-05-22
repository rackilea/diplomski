import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

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

        private final LinkedList<SmileyFace> faces;

        public MyPanel() {
            faces = new LinkedList<>();
            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    faces.add(new SmileyFace(e.getX(), e.getY()));
                    MyPanel.this.repaint(); // Refresh the display on the screen
                }
            });
        }

        @Override
        public void paintComponent(final Graphics g) {
            super.paintComponent(g);
            faces.stream().forEach((e) -> e.render(g));
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 400);
        }

    }

    public class SmileyFace {

        private final int x;
        private final int y;

        public SmileyFace(final int x, final int y) {
            this.x = x;
            this.y = y;
        }

        public void render(final Graphics g) {

            g.setColor(Color.YELLOW);
            g.fillOval(x, y, 50, 50);
            g.setColor(Color.BLACK);
            g.drawOval(x, y, 50, 50);

            g.drawLine(x + 20, y + 10, x + 20, y + 20);
            g.drawLine(x + 30, y + 10, x + 30, y + 20);

            g.drawArc(x + 15, y + 15, 20, 20, 180, 180);
        }

    }

}