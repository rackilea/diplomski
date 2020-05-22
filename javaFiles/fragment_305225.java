import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

/**
 * @author Obicere
 */
public class MovingSquare {

    private volatile int viewportWidth;
    private volatile int viewportHeight;

    private final LinkedList<Square> squares = new LinkedList<>();

    public MovingSquare() {
        final JFrame frame = new JFrame("Moving Square");
        final JPanel displayPanel = new JPanel() {
            @Override
            protected void paintComponent(final Graphics g) {
                synchronized (squares) {
                    for (final Square square : squares) {

                        // Update the square's locations, ideally this will
                        // be separate of the painting thread
                        square.doUpdate();
                        final int x = (int) square.getX();
                        final int y = (int) square.getY();

                        g.setColor(square.getColor());
                        g.drawRect(x, y, square.squareSize, square.squareSize);

                    }
                }
            }
        };

        displayPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(final MouseEvent e) {
                final Color nextColor = Color.getHSBColor((float) Math.random(), 1, 0.5f);
                final float speedX = (float) Math.random();
                final float speedY = (float) Math.random();

                synchronized (squares) {
                    final Square newSquare = new Square(nextColor, speedX, speedY);
                    squares.add(newSquare);
                    newSquare.x = e.getX();
                    newSquare.y = e.getY();
                }
            }
        });

        displayPanel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                viewportWidth = displayPanel.getWidth();
                viewportHeight = displayPanel.getHeight();
            }
        });

        final Timer repaintTimer = new Timer(20, null);

        repaintTimer.addActionListener(e -> {
            if (!frame.isVisible()) {
                repaintTimer.stop();
                return;
            }
            frame.repaint();
        });
        repaintTimer.start();

        displayPanel.setPreferredSize(new Dimension(200, 200)); // Sorry MadProgrammer
        frame.add(displayPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(MovingSquare::new);
    }


    private class Square {

        private final int squareSize = 25;

        private volatile float x;
        private volatile float y;

        private volatile long lastUpdateTime;

        private volatile boolean negateX;
        private volatile boolean negateY;

        private final float speedX;
        private final float speedY;

        private final Color color;

        public Square(final Color color, final float speedX, final float speedY) {
            this.color = color;
            this.speedX = speedX;
            this.speedY = speedY;

            lastUpdateTime = System.currentTimeMillis();
        }

        /**
         * Important method here!!
         * <p>
         * This updates the location of the squares based off of a set
         * velocity and the difference in times between updates.
         */

        public void doUpdate() {

            // Gets the change in time from last update
            final long currentTime = System.currentTimeMillis();
            final long delta = currentTime - lastUpdateTime;
            if (delta == 0) {
                return;
            }
            // be sure to update the last time it was updated
            lastUpdateTime = currentTime;

            // Calculate the speed based off of the change in time
            final float deltaX = getSpeedX(delta);
            final float deltaY = getSpeedY(delta);

            // Move each square by the change of distance, calculated from
            // the change in time and the velocity.
            final float nextX = x + deltaX;
            final float nextY = y + deltaY;

            handleBouncing(nextX, nextY);
        }

        private void handleBouncing(final float nextX, final float nextY) {

            if (nextX < 0) {
                x = 0;
                flipX();
            } else if (nextX + squareSize >= viewportWidth) {
                x = viewportWidth - squareSize;
                flipX();
            } else {
                x = nextX;
            }

            if (nextY < 0) {
                y = 0;
                flipY();
            } else if (nextY + squareSize >= viewportHeight) {
                y = viewportHeight - squareSize;
                flipY();
            } else {
                y = nextY;
            }
        }

        private float getSpeedX(final long delta) {
            return (negateX ? -1 : 1) * delta * speedX;
        }

        private float getSpeedY(final long delta) {
            return (negateY ? -1 : 1) * delta * speedY;
        }

        protected void flipX() {
            negateX = !negateX;
        }

        protected void flipY() {
            negateY = !negateY;
        }

        public float getX() {
            return x;
        }

        public float getY() {
            return y;
        }

        public Color getColor() {
            return color;
        }

    }
}