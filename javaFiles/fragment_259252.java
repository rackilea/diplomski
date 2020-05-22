import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.net.URL;

class TransparentIcon {
    public static void main(String[] args) throws Exception {
        String imgURL =
            "http://www.gravatar.com/avatar/" +
            "a1ab0af4997654345d7a949877f8037e";
        final BufferedImage image = ImageIO.read(new URL(imgURL));
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ImageIcon icon = new ImageIcon(image);

                JPanel  p = new JPanel(new GridLayout(2,3));
                for (int ii=0; ii<6; ii++) {
                    TransparentLabel tl = new TransparentLabel();
                    tl.setOpacity((ii+1)/6f);
                    tl.setIcon(icon);
                    p.add(tl);
                }

                JOptionPane.showMessageDialog(null, p);
            }
        });
    }
}

class TransparentLabel extends JLabel {

    float opacity = 1f;

    public void setOpacity(float opacity) {
        this.opacity = opacity;
    }

    private Icon getTranslucentIcon(Icon icon) {

        if (icon!=null) {
            BufferedImage bi = new BufferedImage(
                icon.getIconWidth(),
                icon.getIconHeight(),
                BufferedImage.TYPE_INT_ARGB);
            Graphics2D g = bi.createGraphics();
            AlphaComposite ac = AlphaComposite.getInstance(
                AlphaComposite.SRC_OVER,
                opacity);
            g.setComposite(ac);
            icon.paintIcon(this,g,0,0);
            g.dispose();

            return new ImageIcon(bi);
        } else {
            return null;
        }
    }

    public void setIcon(Icon icon) {
        super.setIcon( getTranslucentIcon(icon) );
    }
}