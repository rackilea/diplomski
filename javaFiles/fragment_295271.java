import java.awt.AWTException;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ScreenCapture extends JPanel implements KeyListener {

    private BufferedImage image;

    public ScreenCapture() {
        setSize(1920, 1080);
        setVisible(true);
        image = null;       
    }

    public void setBufferedImage() throws AWTException {
        Robot robot = new Robot();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Rectangle screen = new Rectangle((int) toolkit.getScreenSize().getWidth(), (int) toolkit.getScreenSize().getHeight());
        this.image = robot.createScreenCapture(screen);
        this.repaint();
    }

    public void paint(Graphics g) {
        if (image != null) {
            g.drawImage(image, 0, 0, this);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        try {
            setBufferedImage();
        } catch (AWTException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    public static void main(String [] args) {
        ScreenCapture capture = new ScreenCapture();

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addKeyListener(capture);
        frame.add(capture);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}