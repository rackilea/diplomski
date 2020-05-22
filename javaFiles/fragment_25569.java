import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.*;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.*;

public class MoveIcon extends JPanel {

    private static final long serialVersionUID = 1L;
    private static final String IMAGE_PATH = "http://duke.kenai.com/misc/Bullfight.jpg";
    private static final String IMAGE_PATH_PLAYER = "http://duke.kenai.com/iconSized/duke4.gif";
    public static final int STEP = 3;
    private static final int TIMER_DELAY = STEP * 8;
    private BufferedImage bkgrndImage = null;
    private BufferedImage playerImage = null;
    private Map<Direction, Boolean> directionMap = new HashMap<Direction, Boolean>();
    private int playerX = 0;
    private int playerY = 0;

    enum Direction {

        UP(KeyEvent.VK_UP, 0, -1), DOWN(KeyEvent.VK_DOWN, 0, 1),
        LEFT(KeyEvent.VK_LEFT, -1, 0), RIGHT(KeyEvent.VK_RIGHT, 1, 0);
        private int keyCode;
        private int xDirection;
        private int yDirection;

        private Direction(int keyCode, int xDirection, int yDirection) {
            this.keyCode = keyCode;
            this.xDirection = xDirection;
            this.yDirection = yDirection;
        }

        public int getKeyCode() {
            return keyCode;
        }

        public int getXDirection() {
            return xDirection;
        }

        public int getYDirection() {
            return yDirection;
        }
    }

    public MoveIcon() {
        try {
            URL bkgrdImageURL = new URL(IMAGE_PATH);
            URL playerImageURL = new URL(IMAGE_PATH_PLAYER);
            bkgrndImage = ImageIO.read(bkgrdImageURL);
            playerImage = ImageIO.read(playerImageURL);
            setPreferredSize(new Dimension(bkgrndImage.getWidth(), bkgrndImage.getHeight()));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Direction direction : Direction.values()) {
            directionMap.put(direction, false);
        }
        setKeyBindings();
        Timer timer = new Timer(TIMER_DELAY, new TimerListener());
        timer.start();
    }

    private void setKeyBindings() {
        InputMap inMap = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actMap = getActionMap();
        for (final Direction direction : Direction.values()) {
            KeyStroke pressed = KeyStroke.getKeyStroke(direction.getKeyCode(), 0, false);
            KeyStroke released = KeyStroke.getKeyStroke(direction.getKeyCode(), 0, true);
            inMap.put(pressed, direction.toString() + "pressed");
            inMap.put(released, direction.toString() + "released");
            actMap.put(direction.toString() + "pressed", new AbstractAction() {

                private static final long serialVersionUID = 1L;

                @Override
                public void actionPerformed(ActionEvent e) {
                    directionMap.put(direction, true);
                }
            });
            actMap.put(direction.toString() + "released", new AbstractAction() {

                private static final long serialVersionUID = 1L;

                @Override
                public void actionPerformed(ActionEvent e) {
                    directionMap.put(direction, false);
                }
            });
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (bkgrndImage != null) {
            g.drawImage(bkgrndImage, 0, 0, null);
        }
        if (playerImage != null) {
            g.drawImage(playerImage, playerX, playerY, null);
        }
    }

    private class TimerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            boolean moved = false;
            for (Direction direction : Direction.values()) {
                if (directionMap.get(direction)) {
                    playerX += STEP * direction.getXDirection();
                    playerY += STEP * direction.getYDirection();
                    moved = true;
                }
            }
            if (moved) {
                int x = playerX - 2 * STEP;
                int y = playerY - 2 * STEP;
                int w = playerImage.getWidth() + 4 * STEP;
                int h = playerImage.getHeight() + 4 * STEP;
                MoveIcon.this.repaint(x, y, w, h); // !! repaint just the player
            }
        }
    }

    private static void createAndShowUI() {
        JFrame frame = new JFrame("MoveIcon");
        frame.getContentPane().add(new MoveIcon());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                createAndShowUI();
            }
        });
    }
}