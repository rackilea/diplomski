import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.GeneralPath;
import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.plaf.basic.BasicButtonUI;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                JButton btn = new JButton();
                btn.setUI(new PlayButtonUI());
                frame.add(btn);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class PlayButtonUI extends BasicButtonUI {

        @Override
        public Dimension getPreferredSize(JComponent c) {
            return new Dimension(200, 200);
        }

        @Override
        public void paint(Graphics g, JComponent c) {
            Graphics2D g2 = (Graphics2D) g;
            AbstractButton b = (AbstractButton) c;
            ButtonModel model = b.getModel();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);//smoth borders
            if (model.isArmed()) {
                g2.setColor(Color.BLACK);//color when button is pressed
            } else {
                g2.setColor(Color.GRAY);//default button color
            }

            float thinkness = Math.min(c.getWidth(), c.getHeight()) * 0.1f;

            Shape shape = shapeFor(c, thinkness);
            g2.setStroke(new BasicStroke(thinkness, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            g2.fill(shape);//aplying color
            g2.draw(shape);

            super.paint(g2, c);
        }

        private Shape shapeFor(JComponent c, float thickness) {
            GeneralPath gp = new GeneralPath();

            double width = c.getWidth();
            double height = c.getHeight();
            double vPos = height / 2.0;
            double hPos = width - thickness;

            gp.moveTo(0.0 + thickness, 0.0 + thickness);
            gp.lineTo(hPos, vPos);
            gp.lineTo(0.0 + thickness, height - thickness);
            gp.closePath();

            return gp;
        }

    }
}