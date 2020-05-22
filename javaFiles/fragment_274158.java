import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.plaf.basic.BasicProgressBarUI;

/** @see http://stackoverflow.com/questions/8884297 */
public class ProgressBarUITest extends JPanel {

    public ProgressBarUITest() {
        super(new BorderLayout());
        JProgressBar jpb = new JProgressBar();
        jpb.setUI(new MyProgressUI());
        jpb.setForeground(Color.GRAY);
        jpb.setIndeterminate(true);
        this.add(jpb);
    }

    private static class MyProgressUI extends BasicProgressBarUI {

        private static final int ARC_EXTENT = 25;

        @Override
        protected void installDefaults() {
            super.installDefaults();
            progressBar.setBorder(null);
        }

        @Override
        protected void paintIndeterminate(Graphics g, JComponent c) {
            int angle = (int) (90 - 360.0 * getAnimationIndex() / getFrameCount());
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g.setColor(progressBar.getForeground());
            int size = Math.min(c.getWidth(), c.getHeight());
            g2d.fillArc((c.getWidth() - size) / 2, (c.getHeight() - size) / 2, size, size, angle - ARC_EXTENT, ARC_EXTENT);
        }

        @Override
        protected Rectangle getBox(Rectangle r) {
            if (r != null) {
                r.setBounds(progressBar.getBounds());
                return r;
            }
            return progressBar.getBounds();
        }

        @Override
        public Dimension getPreferredSize(JComponent c) {
            return new Dimension(100, 100);
        }
    }

    private void display() {
        JFrame f = new JFrame("ProgressBarUITest");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(this);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new ProgressBarUITest().display();
            }
        });
    }
}