import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;
import java.util.ArrayList;

public class Canvas2 extends JPanel {
    // attributes
    private Rectangle player1;
    private Rectangle player2;
    private ArrayList<KeyEvent> log;

    private boolean player1left = false;
    private boolean player1right = false;
    private boolean player1up = false;
    private boolean player1down = false;
    private boolean player2left = false;
    private boolean player2right = false;
    private boolean player2up = false;
    private boolean player2down = false;

    // constructor
    public Canvas2() {
        // initialize object
        player1 = new Rectangle(50, 50, 50, 50);
        player2 = new Rectangle(50, 50, 50, 50);

        log = new ArrayList<KeyEvent>();

        // set canavs background colour
        setBackground(Color.white);

        // add the key listener in the constructor of your canavas/panel
        addKeyListener(new myKeyListener());

        // ensure focus is on this canavas/panel for key operations.
        setFocusable(true);

        Thread gameLoop = new Thread() {
            public void run() {
                while (true) {
                    updatePlayers();
                    repaint();
                    pause(10);
                }

            }
        };

        gameLoop.start();

    }

    private void updatePlayers() {
        if (player1left) {
            moveX(-5, player1);
        }
        if (player1right) {
            moveX(5, player1);
        }
        if (player1up) {
            moveY(-5, player1);
        }
        if (player1down) {
            moveY(5, player1);
        }
        if (player2left) {
            moveX(-5, player2);
        }
        if (player2right) {
            moveX(5, player2);
        }
        if (player2up) {
            moveY(-5, player2);
        }
        if (player2down) {
            moveY(5, player2);
        }
    }

    // painting
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2d = (Graphics2D) graphics;

        graphics.setColor(Color.blue);
        graphics2d.fill(player1);
        graphics2d.fill(player2);
    }

    // function which essentially re-creates rectangle with varying x
    // orientations. (x-movement)
    public void moveX(int mutationDistance, Rectangle sampleObject) {
        sampleObject.setBounds(sampleObject.x + mutationDistance,
                sampleObject.y, sampleObject.width, sampleObject.height);
    }

    // function which essentially re-creates rectangle with varying y
    // orientations. (y-movement)
    public void moveY(int mutationDistance, Rectangle sampleObject) {
        sampleObject.setBounds(sampleObject.x, sampleObject.y
                + mutationDistance, sampleObject.width, sampleObject.height);
    }

    // listener
    private class myKeyListener implements KeyListener {
        // implement all the possible actions on keys
        public void keyPressed(final KeyEvent keyEvent) {
            if (keyEvent.getKeyCode() == KeyEvent.VK_ESCAPE) {
                System.exit(0);
            }

            if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
                player1right = true;
            }
            if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT) {
                player1left = true;
            }
            if (keyEvent.getKeyCode() == KeyEvent.VK_UP) {
                player1up = true;
            }
            if (keyEvent.getKeyCode() == KeyEvent.VK_DOWN) {
                player1down = true;
            }

            if (keyEvent.getKeyCode() == KeyEvent.VK_D) {
                player2right = true;
            }
            if (keyEvent.getKeyCode() == KeyEvent.VK_A) {
                player2left = true;
            }
            if (keyEvent.getKeyCode() == KeyEvent.VK_W) {
                player2up = true;
            }
            if (keyEvent.getKeyCode() == KeyEvent.VK_S) {
                player2down = true;
            }


        }

        public void keyReleased(KeyEvent keyEvent) {
            if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
                player1right = false;
            }
            if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT) {
                player1left = false;
            }
            if (keyEvent.getKeyCode() == KeyEvent.VK_UP) {
                player1up = false;
            }
            if (keyEvent.getKeyCode() == KeyEvent.VK_DOWN) {
                player1down = false;
            }

            if (keyEvent.getKeyCode() == KeyEvent.VK_D) {
                player2right = false;
            }
            if (keyEvent.getKeyCode() == KeyEvent.VK_A) {
                player2left = false;
            }
            if (keyEvent.getKeyCode() == KeyEvent.VK_W) {
                player2up = false;
            }
            if (keyEvent.getKeyCode() == KeyEvent.VK_S) {
                player2down = false;
            }
        }

        public void keyTyped(KeyEvent keyEvent) {
        }
    }

    public static void pause(int secs) {
        try {
            Thread.sleep(secs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}