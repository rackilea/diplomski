import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.WindowConstants;

public class PaintImage {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                startUI();
            }
        });
    }

    private static void startUI() {
        final JFrame mainFrm = new JFrame("Main");
        final JFrame paintFrame = new JFrame("Copy");
        mainFrm.add(new JScrollPane(new JTree()), BorderLayout.WEST);
        mainFrm.add(new JScrollPane(new JTextArea("Write your text here...")), BorderLayout.CENTER);
        mainFrm.pack();
        mainFrm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrm.setLocationRelativeTo(null);

        final JLabel label = new JLabel("");
        paintFrame.add(label);
        paintFrame.setSize(mainFrm.getSize());
        paintFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mainFrm.setVisible(true);
        paintFrame.setVisible(true);

        final Timer t = new Timer(200, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                final Image img = getScreenShot(mainFrm.getContentPane());
                label.setIcon(new ImageIcon(img));
            }
        });
        t.start();
    }

    public static BufferedImage getScreenShot(Component component) {

        final BufferedImage image = new BufferedImage(
                component.getWidth(),
                component.getHeight(),
                BufferedImage.TYPE_INT_RGB
                );
        // call the Component's paint method, using
        // the Graphics object of the image.
        component.paint( image.getGraphics() ); // alternately use .printAll(..)
        return image;
    }
}