import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/** @see https://stackoverflow.com/q/9625495/230513 */
public class LayerDemo extends JFrame {

    private static final Dimension d = new Dimension(320, 240);

    public LayerDemo() {
        JLayeredPane layers = new JLayeredPane();
        layers.setPreferredSize(d);

        layers.add(new LayerPanel(1 * d.height / 8), 100);
        layers.add(new LayerPanel(2 * d.height / 8), 101);
        layers.add(new LayerPanel(3 * d.height / 8), 102);

        this.add(layers, BorderLayout.CENTER);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setLocationByPlatform(true);
    }

    private static class LayerPanel extends JPanel {

        private static final Random r = new Random();
        private int n;
        private Color color = new Color(r.nextInt());

        public LayerPanel(int n) {
            this.n = n;
            this.setOpaque(false);
            this.setBounds(n, n, d.width / 2, d.height / 2);
            this.addMouseListener(new MouseHandler(this));
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(color);
            g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 16, 16);
            g2d.setColor(Color.black);
            g2d.drawString(String.valueOf(n), 5, getHeight() - 5);
        }

        private void update() {
            color = new Color(r.nextInt());
            repaint();
        }
    }

    private static class MouseHandler extends MouseAdapter {

        LayerPanel panel;

        MouseHandler(LayerPanel panel) {
            this.panel = panel;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            panel.update();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                (new LayerDemo()).setVisible(true);
            }
        });
    }
}