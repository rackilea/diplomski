import java.awt.image.BufferedImage;
import java.awt.*;
import javax.swing.*;

import java.net.URL;
import javax.imageio.ImageIO;

class RedAndWhite {

    public static Image getColoredImage(Color color, int size) {
        BufferedImage bi = new BufferedImage(
            size,
            size,
            BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.getGraphics();
        g.setColor(color);
        g.fillRect(0,0,size,size);

        g.dispose();
        return bi;
    }

    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Image red = getColoredImage(Color.RED, 32);
                Image white = getColoredImage(Color.WHITE, 32);
                JPanel p = new JPanel(new GridLayout(1,0,5,5));

                ButtonGroup bg = new ButtonGroup();
                for (int ii=0; ii<6; ii++) {
                    JRadioButton b = new JRadioButton();
                    b.setSelectedIcon(new ImageIcon(red));
                    b.setIcon(new ImageIcon(white));
                    b.setContentAreaFilled(true);
                    bg.add(b);
                    p.add(b);
                }

                JOptionPane.showMessageDialog(null, p);
            }
        });
    }
}