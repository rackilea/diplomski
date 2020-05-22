import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class BadPaint21 {

    public static void main(String[] args) {
        new BadPaint21();
    }

    public BadPaint21() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D graphics = (Graphics2D) g.create();
//            Dimension dimension = frame.getSize();
            Insets insets = getInsets();
            int w = (int) ((getWidth() - insets.left - insets.right) / 2);
            int h = (int) ((getHeight() - insets.top - insets.bottom) / 2);
            graphics.translate(w, h);
            graphics.drawString("Origin", 0, 0);
            double y = 0;
            for (double x = -25; x <= 25; x += .01) {
                y = -Math.pow(x, 2);
                int gx = (int) x;
                int gy = (int) y;
                System.out.println("Parabola Coordinate: " + x + ", " + y);
                graphics.drawRect(gx, gy, 0, 0);
            }
            graphics.dispose();
        }
    }
}