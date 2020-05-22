import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestKeyListener01 {

    public static void main(String[] args) {
        new TestKeyListener01();
    }

    public TestKeyListener01() {
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

        private boolean arrowUp = false;
        private boolean arrowDown = false;
        private boolean arrowLeft = false;
        private boolean arrowRight = false;

        public TestPane() {
            setFocusable(true);
            addKeyListener(new KeyAdapter() {

                @Override
                public void keyReleased(KeyEvent e) {
                    switch (e.getKeyCode()) {
                        case KeyEvent.VK_DOWN:
                            arrowDown = false;
                            break;
                        case KeyEvent.VK_UP:
                            arrowUp = false;
                            break;
                        case KeyEvent.VK_LEFT:
                            arrowLeft = false;
                            break;
                        case KeyEvent.VK_RIGHT:
                            arrowRight = false;
                            break;
                    }
                    repaint();
                }

                @Override
                public void keyPressed(KeyEvent e) {
                    switch (e.getKeyCode()) {
                        case KeyEvent.VK_DOWN:
                            arrowDown = true;
                            break;
                        case KeyEvent.VK_UP:
                            arrowUp = true;
                            break;
                        case KeyEvent.VK_LEFT:
                            arrowLeft = true;
                            break;
                        case KeyEvent.VK_RIGHT:
                            arrowRight = true;
                            break;
                    }
                    repaint();
                }
            });
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            FontMetrics fm = g2d.getFontMetrics();
            String text = "Up";
            int x = (getWidth() - fm.stringWidth(text)) / 2;
            int y = ((getHeight() / 2) - fm.getHeight());
            draw(g2d, text, x, y, arrowUp);

            text = "Down";
            x = (getWidth() - fm.stringWidth(text)) / 2;
            y = ((getHeight() / 2) + fm.getHeight()) + fm.getAscent();
            draw(g2d, text, x, y, arrowDown);

            text = "Left";
            x = (getWidth() / 2) - fm.stringWidth(text) - 4;
            y = ((getHeight() - fm.getHeight()) / 2) + fm.getAscent();
            draw(g2d, text, x, y, arrowLeft);

            text = "Right";
            x = (getWidth() / 2) + 4;
            y = ((getHeight() - fm.getHeight()) / 2) + fm.getAscent();
            draw(g2d, text, x, y, arrowRight);

            g2d.dispose();
        }

        protected void draw(Graphics2D g2d, String text, int x, int y, boolean pressed) {
            g2d.setColor(pressed ? Color.BLACK : Color.GRAY);
            g2d.drawString(text, x, y);
        }
    }
}