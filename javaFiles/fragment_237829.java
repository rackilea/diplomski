import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
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

                TestPane testPane = new TestPane();
                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(testPane);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                // The component needs to be attached to displayed window before
                // the buffer can be created
                testPane.startPainting();
            }
        });
    }

    public class TestPane extends Canvas {

        private AtomicBoolean painting = new AtomicBoolean(true);
        private PaintCycle paintCycle;

        private Rectangle clickBounds;

        public TestPane() {
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (clickBounds != null && clickBounds.contains(e.getPoint())) {
                        painting.set(false);
                    }
                }
            });
        }

        public void startPainting() {
            if (paintCycle == null) {
                createBufferStrategy(2);
                painting.set(true);
                paintCycle = new PaintCycle();
                Thread t = new Thread(paintCycle);
                t.setDaemon(true);
                t.start();
            }
        }

        public void stopPainting() {
            if (paintCycle != null) {
                painting.set(false);
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        public class PaintCycle implements Runnable {

            private BufferStrategy strategy;
            private int xDelta = 2;
            private int yDelta = 2;

            @Override
            public void run() {
                System.out.println("Painting has started");

                int x = (int) (Math.random() * (getWidth() - 40));
                int y = (int) (Math.random() * (getHeight() - 40));

                do {
                    xDelta = (int) (Math.random() * 8) - 4;
                } while (xDelta == 0);
                do {
                    yDelta = (int) (Math.random() * 8) - 4;
                } while (yDelta == 0);

                clickBounds = new Rectangle(x, y, 40, 40);
                strategy = getBufferStrategy();
                while (painting.get()) {
                    // Update the state of the model...
                    update();
                    // Paint the state of the model...
                    paint();
                    try {
                        // What ever calculations you want to use to maintain the framerate...
                        Thread.sleep(40);
                    } catch (InterruptedException ex) {
                    }
                }
                System.out.println("Painting has stopped");
            }

            protected void update() {
                int x = clickBounds.x + xDelta;
                int y = clickBounds.y + yDelta;

                if (x + 40 > getWidth()) {
                    x = getWidth() - 40;
                    xDelta *= -1;
                } else if (x < 0) {
                    x = 0;
                    xDelta *= -1;
                }
                if (y + 40 > getHeight()) {
                    y = getHeight() - 40;
                    yDelta *= -1;
                } else if (y < 0) {
                    y = 0;
                    yDelta *= -1;
                }

                clickBounds.setLocation(x, y);
            }

            protected void paint() {
                // Render single frame
                do {
                    // The following loop ensures that the contents of the drawing buffer
                    // are consistent in case the underlying surface was recreated
                    do {
                        // Get a new graphics context every time through the loop
                        // to make sure the strategy is validated
                        Graphics2D graphics = (Graphics2D) strategy.getDrawGraphics();

                        // Render to graphics
                        // ...
                        graphics.setColor(Color.BLUE);
                        graphics.fillRect(0, 0, getWidth(), getHeight());

                        graphics.setColor(Color.RED);
                        graphics.fill(clickBounds);

                        // Dispose the graphics
                        graphics.dispose();

                        // Repeat the rendering if the drawing buffer contents
                        // were restored
                    } while (strategy.contentsRestored());

                    // Display the buffer
                    strategy.show();

                    // Repeat the rendering if the drawing buffer was lost
                } while (strategy.contentsLost());
            }

        }

    }

}