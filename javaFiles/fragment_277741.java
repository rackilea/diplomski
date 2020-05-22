import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestLabel101 {

    public static void main(String[] args) {
        new TestLabel101();
    }

    public TestLabel101() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JLabel {

        public TestPane() {
            setText("Happy, Happy");
            setForeground(Color.WHITE);
            setHorizontalAlignment(CENTER);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g.create();
            LinearGradientPaint lgp = new LinearGradientPaint(
                    new Point(0, 0), 
                    new Point(0, getHeight()), 
                    new float[]{0.142f, 0.284f, 0.426f, 0.568f, 0.71f, 0.852f, 1f}, 
                    new Color[]{Color.PINK, Color.MAGENTA, Color.BLUE, Color.GREEN, Color.YELLOW, Color.ORANGE, Color.RED});
            g2d.setPaint(lgp);
            g2d.fill(new Rectangle(0, 0, getWidth(), getHeight()));
            g2d.dispose();
            super.paintComponent(g);
        }

    }

}