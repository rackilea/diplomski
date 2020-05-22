import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/** @see https://stackoverflow.com/questions/5838842 */
public class RescaleOpTest extends JPanel {

    public static final String LINK =
        "http://www.freeimagehosting.net/uploads/576c64ef7b.png";

    public RescaleOpTest() {
        this.setLayout(new GridLayout(1, 0));
        Image img = null;
        try {
            img = ImageIO.read(new URL(LINK));
//            img = ImageIO.read(new File("image.jpg"));
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
        int w = img.getWidth(null);
        int h = img.getHeight(null);
        BufferedImage bi = new BufferedImage(
            w, h, BufferedImage.TYPE_4BYTE_ABGR_PRE);
        Graphics2D g = bi.createGraphics();
        g.drawImage(img, 0, 0, null);
        g.dispose();

        /* Create a rescale filter op that makes the image 75% opaque */
        float[] scales = {1f, 1f, 1f, 0.75f};
        float[] offsets = new float[4];
        RescaleOp rop = new RescaleOp(scales, offsets, null);
        bi = rop.filter(bi, null);
        this.add(new JLabel(new ImageIcon(img)));
        this.add(new JLabel(new ImageIcon(bi)));
    }

    private void display() {
        JFrame f = new JFrame("RescaleOpTest");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(this);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new RescaleOpTest().display();
            }
        });
    }
}