import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

class ImageCrop {

    public static void main(String[] args) throws Exception {
        URL url = new URL("http://i.stack.imgur.com/enifS.jpg");
        final BufferedImage image = ImageIO.read(url);
        int x = 43;
        final Image crop = image.getSubimage(x, 0, image.getWidth()-x, image.getHeight());
        Runnable r = new Runnable() {

            @Override
            public void run() {
                JPanel gui = new JPanel(new BorderLayout(4,4));

                gui.add(new JLabel(new ImageIcon(image)), BorderLayout.LINE_START);
                gui.add(new JLabel(new ImageIcon(crop)), BorderLayout.LINE_END);

                JOptionPane.showMessageDialog(null, gui);
            }
        };
        // Swing GUIs should be created and updated on the EDT
        // http://docs.oracle.com/javase/tutorial/uiswing/concurrency/initial.html
        SwingUtilities.invokeLater(r);
    }
}