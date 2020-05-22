import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.geom.Path2D;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class FunkyShapedComponent {

    public static void main(String[] args) {
        new FunkyShapedComponent();
    }

    public FunkyShapedComponent() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JPanel testPane = new JPanel();
                testPane.setBackground(Color.RED);
                testPane.setLayout(new GridBagLayout());
                testPane.add(new FunkyPane());

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(testPane);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class FunkyPane extends JPanel {

        public FunkyPane() {
            setLayout(new GridBagLayout());
            add(new JLabel("This is a simple test"));
            setOpaque(false);
        }

        @Override
        public Insets getInsets() {
            return new Insets(10, 10, 10, 10);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            int width = getWidth() - 1;
            int height = getHeight() - 1;

            int radius = Math.min(width, height) / 10;

            Path2D p = new Path2D.Float();
            p.moveTo(0, radius / 2);
            p.curveTo(0, 0, 0, 0, radius / 2, 0);
            p.curveTo(width / 4, radius, width / 4, radius, (width / 2) - radius, radius / 2);
            p.curveTo(width / 2, 0, width / 2, 0, (width / 2) + radius, radius / 2);
            p.curveTo(width - (width / 4), radius, width - (width / 4), radius, width - (radius / 2), 0);
            p.curveTo(width, 0, width, 0, width, radius / 2);

            p.curveTo(width - radius, height / 4, width - radius, height / 4, width - (radius / 2), (height / 2) - radius);
            p.curveTo(width, height / 2, width, height / 2, width - (radius / 2), (height / 2) + radius);
            p.curveTo(width - radius, height - (height / 4), width - radius, height - (height / 4), width, height - (radius / 2));
            p.curveTo(width, height, width, height, width - (radius / 2), height);

            p.curveTo(width - (width / 4), height - radius, width - (width / 4), height - radius, (width / 2) + radius, height - (radius / 2));
            p.curveTo(width / 2, height, width / 2, height, (width / 2) - radius, height - (radius / 2));
            p.curveTo((width / 4), height - radius, (width / 4), height - radius, (radius / 2), height);
            p.curveTo(0, height, 0, height, 0, height - (radius / 2));

            p.curveTo(radius, height - (height / 4), radius, height - (height / 4), (radius / 2), (height / 2) + radius);
            p.curveTo(0, height / 2, 0, height / 2, (radius / 2), (height / 2) - radius);
            p.curveTo(radius, (height / 4), radius, (height / 4), 0, (radius / 2));

            p.closePath();

            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
            g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
            g2d.setColor(getBackground());
            g2d.fill(p);
            g2d.dispose();

        }
    }
}