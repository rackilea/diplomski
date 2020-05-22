import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class TestImageResize {

    protected void initUI() throws MalformedURLException, IOException {
        final JFrame frame = new JFrame(TestImageResize.class.getSimpleName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BufferedImage bi = ImageIO.read(new URL(
                "http://www.desktopwallpaperhd.net/wallpapers/19/5/islands-paradise-maldive-nature-background-image-landscape-194469.jpg"));
        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel(new ImageIcon(bi));
        panel.add(label);
        MouseMotionListener doScrollRectToVisible = new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Rectangle r = new Rectangle(e.getX(), e.getY(), 1, 1);
                ((JPanel) e.getSource()).scrollRectToVisible(r);
            }
        };
        panel.addMouseMotionListener(doScrollRectToVisible);

        panel.setAutoscrolls(true);
        frame.add(new JScrollPane(panel));
        frame.pack();
        frame.setSize(frame.getWidth() / 2, frame.getHeight() / 2);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    new TestImageResize().initUI();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}