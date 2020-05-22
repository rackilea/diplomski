import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestSpeed {

    public static void main(String[] args) {
        new TestSpeed();
    }

    public TestSpeed() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Test");
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

        private BufferedImage background;
        // The current position of the background
        private int xPos = 0;
        // The speed/delta that the xPos is changed...
        private int xDelta = 0;

        public TestPane() {
            Timer timer = new Timer(40, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (xPos < -(getWidth())) {
                        xPos = 0;
                    }
                    xPos -= xDelta;
                    repaint();
                }
            });
            timer.setRepeats(true);
            timer.setCoalesce(true);
            timer.start();
            InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "slower");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "faster");

            ActionMap am = getActionMap();
            am.put("slower", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setSpeed(-1);
                }
            });
            am.put("faster", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setSpeed(1);
                }
            });
        }

        protected void setSpeed(int delta) {
            xDelta += delta;
            // Check the change in speed to ensure it's within the appropriate range
            if (xDelta < 0) {
                xDelta = 0;
            } else if (xDelta > 9) {
                xDelta = 9;
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        public void invalidate() {
            background = null;
            super.invalidate();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            int x = xPos;
            g.setColor(Color.DARK_GRAY);
            while (x < getWidth()) {
                g.drawLine(x, 0, x, getHeight());
                x += 15;
            }

            int width = getWidth();
            int height = getHeight();
            x = (width / 2) - 5;
            int y = (height / 2) - 5;
            g.setColor(Color.RED);
            g.fillOval(x, y, 10, 10);
        }        
    }    
}