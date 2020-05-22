import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ScreenCapture extends JLabel implements KeyListener {

    private BufferedImage image;

    public ScreenCapture() {
        setSize(1920, 1080);
        setVisible(true);
        image = null;
    }

    public void setBufferedImage() throws AWTException {
        Robot robot = new Robot();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Rectangle screen = new Rectangle((int) toolkit.getScreenSize()
                .getWidth(), (int) toolkit.getScreenSize().getHeight());
        this.image = robot.createScreenCapture(screen);
        this.setIcon(new ImageIcon(this.image));
        this.repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        try {
            setBufferedImage();
        } catch (AWTException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public static void main(String[] args) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        ScreenCapture capture = new ScreenCapture();
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(capture);
        panel.add(scroll, BorderLayout.CENTER);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.addKeyListener(capture);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}