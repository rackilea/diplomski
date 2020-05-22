import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagLayout;
import java.awt.LinearGradientPaint;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author swhitehead
 */
public class JavaApplication233 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GraphicsEnvironment ge
                        = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();

        //If translucent windows aren't supported, exit.
        if (!gd.isWindowTranslucencySupported(GraphicsDevice.WindowTranslucency.PERPIXEL_TRANSLUCENT)) {
            System.err.println("Per-pixel translucency is not supported");
            System.exit(0);
        } else {
            new JavaApplication233();
        }
    }

    public JavaApplication233() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setUndecorated(true);
                frame.setBackground(new Color(0, 0, 0, 0));
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            setOpaque(false);
            setLayout(new GridBagLayout());
            add(new JLabel("I'm not wearing anything"));
//          Color color = UIManager.getColor("activeCaptionBorder");
            setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            LinearGradientPaint lgp = new LinearGradientPaint(
                            new Point(0, 0),
                            new Point(0, getHeight()),
                            new float[]{0f, 1f},
                            new Color[]{applyAlpha(Color.RED), applyAlpha(Color.YELLOW)}
            );
            g2d.setPaint(lgp);
            g2d.fill(new Rectangle(0, 0, getWidth(), getHeight()));
            g2d.dispose();
        }

        protected Color applyAlpha(Color color) {
            return new Color(color.getRed(), color.getGreen(), color.getBlue(), 64);
        }

    }

}