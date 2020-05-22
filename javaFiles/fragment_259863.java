import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JPanel {

    private JFrame frame;
    private BufferStrategy strat;
    private boolean stillPlaying;

    public Game() {
        frame = new JFrame("Pirate Game!");

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        frame.getContentPane().add(this);
        setIgnoreRepaint(true);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
        stillPlaying = true;
    }

    public static void main(String[] args) {
        Game g = new Game();
        g.runGameLoop();
    }

    private void runGameLoop() {
        long initLoop = System.currentTimeMillis();
        // while(stillPlaying){
        long change = initLoop - System.currentTimeMillis();
        initLoop = System.currentTimeMillis();
        //Graphics2D gfx = (Graphics2D) strat.getDrawGraphics();
        //BufferedImage sourceImage = ImageLoader.getImageLoader().getImage(
                //"stackoverflow.png");
        //gfx.drawImage(sourceImage, 0, 0, null);
        // }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        BufferedImage sourceImage = ImageLoader.getImageLoader().getImage(
                "stackoverflow.png");
        g.drawImage(sourceImage, 0, 0, this);
    }

    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }

}