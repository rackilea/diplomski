import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test1 {

    public static void main(String[] args) {
        new Test1();
    }

    public Test1() {
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

        private int yPos;
        private int dy = 1;
        private int bottom = 50;

        public TestPane() {
            Timer timer = new Timer(40, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    move();
                }
            });
            timer.start();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(500, 500);
        }

        public void move() {

            if (yPos >= getHeight()) {
                dy = -1;
            }
            if (yPos <= 0) {
                dy = 1;
            }
            yPos += dy;
            repaint();

        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int maxHeight = getHeight();
            int width = getWidth();
            int height = maxHeight;
            if (yPos <= maxHeight / 2) {
                g.setColor(Color.green);
                g.fillRect(0, bottom - yPos, width, height);
            }
            if (yPos >= maxHeight / 2 && yPos < (maxHeight / 10) * 9) {
                g.setColor(Color.green);
                g.fillRect(0, bottom - (maxHeight / 2), width, maxHeight / 2);
                g.setColor(Color.green);
                g.fillRect(0, bottom - yPos, width, height - (maxHeight / 2));
            }
            if (yPos >= (maxHeight / 10) * 9) {
                g.setColor(Color.green);
                g.fillRect(0, bottom - (maxHeight / 2), width, maxHeight / 2);
                g.setColor(Color.green);
                g.fillRect(0, bottom - (9 * (maxHeight / 10)), width, (4 * maxHeight) / 10);
                g.setColor(Color.green);
                g.fillRect(0, bottom - yPos, width, height - (9 * (maxHeight) / 10));
            }
            for (int i = 1; i < 6; i++) {
                g.fillRect(0, bottom - (i * (maxHeight / 5)), width, 10);
            }

        }
    }

}