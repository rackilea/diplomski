import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;


public class Mario extends JPanel {

    private static final int D_W = 800;
    private static final int D_H = 300;
    private static final int X_INC = 5;

    BufferedImage bg;
    BufferedImage pipeImg;

    List<Pipe> pipes = new ArrayList<>();

    int delay = 50;

    Timer timer = null;

    public Mario() {

        try {
            bg = ImageIO.read(new URL("http://farm8.staticflickr.com/7341/12338164043_0f68c73fe4_o.png"));
            pipeImg = ImageIO.read(new URL("http://farm3.staticflickr.com/2882/12338452484_7c72da0929_o.png"));
        } catch (IOException ex) {
            Logger.getLogger(Mario.class.getName()).log(Level.SEVERE, null, ex);
        }

        pipes.add(new Pipe(100, 150, pipeImg));
        pipes.add(new Pipe(400, 150, pipeImg));
        pipes.add(new Pipe(700, 150, pipeImg));

        timer = new Timer(delay, new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                for (Pipe pipe : pipes) {
                    if (pipe.x > D_W) {
                        pipe.x = 0;
                    } else {
                        pipe.x += X_INC;
                    }
                }
                repaint();
            }
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
        for (Pipe pipe : pipes) {
            pipe.drawPipe(g);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(D_W, D_H);
    }

    public class Pipe {

        int x;
        int y;
        Image pipe;

        public Pipe(int x, int y, Image pipe) {
            this.x = x;
            this.y = y;
            this.pipe = pipe;
        }

        public void drawPipe(Graphics g) {
            g.drawImage(pipe, x, y, 75, 150, Mario.this);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Mario Pipes");
                frame.add(new Mario());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}