import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @see https://stackoverflow.com/a/16721780/230513
 */
public class Test {

    private void display() {
        JFrame f = new JFrame("Test");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new XORPanel());
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private static class XORPanel extends JPanel {

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(190, 320);
        }

        @Override
        protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            graphics.setColor(Color.black);
            graphics.fillRect(0, 0, getWidth(), getHeight());
            graphics.setColor(Color.green);
            graphics.fillRect(30, 40, 100, 200);
            graphics.setXORMode(Color.white);
            graphics.fillRect(60, 80, 100, 200);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Test().display();
            }
        });
    }
}