import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.*;

public class LadderSnack extends Canvas implements Runnable {
    public static JFrame frame = new JFrame("EmiloLadderSnack v. 1.0");
    public static int width = Toolkit.getDefaultToolkit().getScreenSize().width, height = Toolkit.getDefaultToolkit().getScreenSize().height;
    public boolean run = false;
    public Thread thread;
    public BufferedImage img;
    public int[] pixels;
    public Screen screen;

    public LadderSnack() {
        screen = new Screen(width, height);
        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
        pixels = ((DataBufferInt) img.getRaster().getDataBuffer()).getData();
    }

    public void start() {
        if (run)
            return;
        run = true;
        thread = new Thread(this);
        thread.start();
    }

    public void stop() {
        if (!run)
            return;
        try {
            thread.join();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public void run() {
        while (run) {
            trick();
            render();
        }
    }

    private void trick() {
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }
        for (int i = 0; i < width * height; i++)
            pixels[i] = screen.pixels[i];
        Graphics g = bs.getDrawGraphics();
        g.drawImage(img, 0, 0, width, height, null);
        g.dispose();
        bs.show();
    }

    public static void main(String[] args) {
        LadderSnack ladderSnack = new LadderSnack();

        frame.setSize(width, height);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.add(ladderSnack);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        ladderSnack.start();
    }
}