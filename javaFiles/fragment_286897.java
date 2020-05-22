import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

class GTest {

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GPanel gPanel = new GPanel();
        JPanel bPanel = new JPanel();
        bPanel.setBorder(BorderFactory.createTitledBorder("Title"));
        bPanel.add(gPanel);
        f.add(bPanel);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private static class GPanel extends JPanel {

        private static final int N = 16;

        private void doDrawing(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setPaint(Color.red);
            g.fillOval(-N, -N, 2 * N, 2 * N);
            g2.translate(getWidth() / 2, getHeight() / 2);
            g2.setPaint(Color.blue);
            g.fillOval(-N, -N, 2 * N, 2 * N);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            doDrawing(g);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(256, 256);
        }
    }
}