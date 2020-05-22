import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @see https://stackoverflow.com/a/16014525/230513
 */
public class UnleadedTest {

    private static class Unleaded extends JComponent {

        private Font font = new Font("Verdana", Font.PLAIN, 144);
        private FontRenderContext frc = new FontRenderContext(null, true, true);
        private String text;
        private TextLayout layout;
        private Rectangle r;

        public Unleaded(String text) {
            this.text = text;
            calcBounds();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(r.width, r.height);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            calcBounds();
            layout.draw(g2d, -r.x, -r.y);
        }

        private void calcBounds() {
            layout = new TextLayout(text, font, frc);
            r = layout.getPixelBounds(null, 0, 0);
        }
    }

    private void display() {
        JFrame f = new JFrame("Unleaded");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Unleaded label = new Unleaded("Unleaded");

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Title"));
        panel.add(label);
        f.add(panel);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new UnleadedTest().display();
            }
        });
    }
}