import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicButtonUI;

/** @see http://stackoverflow.com/questions/5169647 */
public class ButtonUITest extends JPanel {

    public ButtonUITest() {
        this.setLayout(new GridLayout(1, 0));
        this.setPreferredSize(new Dimension(640, 480));
        this.add(new CustomButton(true));
        this.add(new CustomButton(false));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int w = this.getWidth();
        int h = this.getHeight();
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(new GradientPaint(0, 0, Color.blue, w, h, Color.red));
        g2d.fillRect(0, 0, w, h);
    }

    private void display() {
        JFrame f = new JFrame("ButtonUITest");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(this);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private static class CustomButton extends JButton {

        public CustomButton(boolean antialiased) {
            this.setOpaque(false);
            this.setUI(new CustomButtonUI(antialiased));
        }
    }

    private static class CustomButtonUI extends BasicButtonUI {

        private boolean antialiased;

        public CustomButtonUI(boolean antialiased) {
            this.antialiased = antialiased;
        }

        @Override
        public void paint(Graphics g, JComponent c) {
            int w = c.getWidth();
            int h = c.getHeight();
            Graphics2D g2d = (Graphics2D) g;
            if (antialiased) {
                g2d.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            }
            g2d.setColor(Color.LIGHT_GRAY);
            g2d.fillOval(0, 0, w, 2 * h);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new ButtonUITest().display();
            }
        });
    }
}