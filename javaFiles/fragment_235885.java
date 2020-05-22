import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestAnimation {

    public static void main(String[] args) {
        new TestAnimation();
    }

    public TestAnimation() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
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
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public class TestPane extends JPanel {

        private BufferedImage img;
        private int xPos, yPos;

        public TestPane() throws IOException {
            img = ImageIO.read(new File("/Users/shane/Dropbox/MegaTokyo/thumnails/2.jpg"));

            xPos = (getPreferredSize().width - img.getWidth()) / 2;
            yPos = (getPreferredSize().height - img.getHeight()) / 2;

            addKeyBinding("up", KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), new KeyAction(0, -4));
            addKeyBinding("down", KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), new KeyAction(0, 4));
            addKeyBinding("left", KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), new KeyAction(-4, 0));
            addKeyBinding("right", KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), new KeyAction(4, 0));
        }

        protected void addKeyBinding(String name, KeyStroke keyStroke, Action action) {
            InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
            ActionMap am = getActionMap();

            im.put(keyStroke, name);
            am.put(name, action);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 400);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (img != null) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.drawImage(img, xPos, yPos, this);
                g2d.dispose();
            }
        }

        public class KeyAction extends AbstractAction {

            private int xDelta, yDelta;

            public KeyAction(int xDelta, int yDelta) {
                this.xDelta = xDelta;
                this.yDelta = yDelta;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                xPos += xDelta;
                yPos += yDelta;
                if (xPos + img.getWidth() > getWidth()) {
                    xPos = getWidth() - img.getWidth();
                } else if (xPos < 0) {
                    xPos = 0;
                }
                if (yPos + img.getHeight() > getHeight()) {
                    yPos = getHeight() - img.getHeight();
                } else if (yPos < 0) {
                    yPos = 0;
                }

                repaint();
            }

        }

    }

}