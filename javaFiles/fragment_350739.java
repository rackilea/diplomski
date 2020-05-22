import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestPaint {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }

        JFrame frame = new JFrame();

        JDesktopPane desktopPane = new JDesktopPane();
        desktopPane.setPreferredSize(new Dimension(1920, 1080));
        JInternalFrame internalFrame = new JInternalFrame("Testing");
        internalFrame.setVisible(true);
        internalFrame.setBounds(100, 100, 500, 500);
        desktopPane.add(internalFrame);

        frame.add(desktopPane);
        frame.pack();

        BufferedImage image = new BufferedImage(1920, 1080, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        desktopPane.printAll(g2d);
        g2d.dispose();

        try {
            ImageIO.write(image, "png", new File("./desktop.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        frame.dispose();
    }

}