import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
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

                Game game = new Game();
                Window window = new Window("Help", game);

                game.start();
            }
        });
    }

    public class Window {

        public Window(String title, Game game) {

            // Creates new JFrame
            JFrame frame = new JFrame(title);

            // Adds Game to window
            frame.add(game);
            frame.setResizable(false);
            frame.pack();

            // Settings of Window
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

        }

    }

    public class Game extends Canvas { //implements Runnable {

//      private Handler handler;

        public Game() {
//
//          handler = new Handler();
//          this.addKeyListener(new KeyInput(handler));
//
//          handler.addObject(new Daanish(100, 100, ID.Player, handler));

        }

        public void start() {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        draw();
                        try {
                            Thread.sleep(40);
                        } catch (InterruptedException ex) {
                        }
                    }
                }
            });
            thread.start();
        }

        public void draw() {

            // Creates a new BufferStrategy
            BufferStrategy bs = this.getBufferStrategy();

            if (bs == null) {
                // This allows the game to preload 3 frames in order to prevent choppy framrate
                this.createBufferStrategy(3);
                return;
            }

            // Create Graphics
            Graphics g = bs.getDrawGraphics();

            g.setColor(Color.cyan);
            g.fillRect(0, 0, 1024, 640);

            g.setColor(Color.black);
            g.fillRect(0, 0, 960, 576);

//          handler.draw(g);

            // Remove frame from queue
            g.dispose();
            bs.show();

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(1024, 640);
        }

    }

}