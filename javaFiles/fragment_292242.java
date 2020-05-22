import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class Test001 {

    public static BufferedImage getFlippedImage(BufferedImage bi) {
        BufferedImage flipped = new BufferedImage(
                bi.getWidth(),
                bi.getHeight(),
                bi.getType());
        AffineTransform tran = AffineTransform.getTranslateInstance(bi.getWidth(), 0);
        AffineTransform flip = AffineTransform.getScaleInstance(-1d, 1d);
        tran.concatenate(flip);

        Graphics2D g = flipped.createGraphics();
        g.setTransform(tran);
        g.drawImage(bi, 0, 0, null);
        g.dispose();

        return flipped;
    }

    Test001(BufferedImage bi) {
        JPanel gui = new JPanel(new GridLayout(1,2,2,2));

        gui.add(new JLabel(new ImageIcon(bi)));
        gui.add(new JLabel(new ImageIcon(getFlippedImage(bi))));

        JOptionPane.showMessageDialog(null, gui);
    }

    public static void main(String[] args) throws AWTException {
        final Robot robot = new Robot();
        Runnable r = new Runnable() {

            @Override
            public void run() {
                final BufferedImage bi = robot.createScreenCapture(
                        new Rectangle(0, 360, 200, 100));
                new Test001(bi);
            }
        };
        SwingUtilities.invokeLater(r);
    }
}