import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
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

    public class TestPane extends JPanel {

        private int xPos, yPos;
        private int xDelta = 2;

        public TestPane() {
            Timer timer = new Timer(40, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int x = (int) (getWidth() * 0.1);
                    int y = (int) (getHeight() * 0.1);
                    int width = getWidth() - (x * 2);
                    int height = getHeight()- (y * 2);

                    xPos += xDelta;
                    yPos = y + ((height - 5) / 2);

                    if (xPos + 10 > x + width) {
                        xPos = x + (width - 10);
                        xDelta *= -1;
                    } else if (xPos < x) {
                        xPos = x;
                        xDelta *= -1;
                    }

                    repaint();
                }
            });
            timer.start();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            int x = (int) (getWidth() * 0.1);
            int y = (int) (getHeight() * 0.1);
            g2d.drawRect(x, y, getWidth() - (x * 2), getHeight() - (y * 2));
            g2d.setColor(Color.RED);
            g2d.drawOval(xPos, yPos, 10, 10);
            g2d.dispose();
        }

    }

}