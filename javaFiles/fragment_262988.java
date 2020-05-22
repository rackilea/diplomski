import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.net.URL;
import javax.imageio.ImageIO;

public class CompassButtons {

    public CompassButtons(BufferedImage bi) {
        int w = bi.getWidth();
        int h = bi.getHeight();
        int step = w / 3;
        JPanel p = new JPanel(new GridLayout(3, 3));
        p.setBackground(Color.BLACK);
        int count = 0;
        for (int ii = 0; ii < w; ii += step) {
            for (int jj = 0; jj < h; jj += step) {
                // This is it - GET THE SUB IMAGE
                Image icon = bi.getSubimage(jj, ii, step, step);
                if (count % 2 == 1) {
                    JButton button = new JButton(new ImageIcon(icon));

                    // remove border, indicate press using different icon
                    button.setBorder(null);

                    // make a 'pressed' icon..
                    BufferedImage iconPressed = new BufferedImage(
                            step, step, BufferedImage.TYPE_INT_ARGB);
                    Graphics g = iconPressed.getGraphics();
                    g.drawImage(icon, 0, 0, p);
                    g.setColor(Color.RED);
                    g.drawRoundRect(
                            0, 0,
                            iconPressed.getWidth(p) - 1, 
                            iconPressed.getHeight(p) - 1,
                            12, 12);
                    g.dispose();
                    button.setPressedIcon(new ImageIcon(iconPressed));

                    // make it transparent
                    button.setContentAreaFilled(false);

                    button.setActionCommand("" + count);
                    button.addActionListener((ActionEvent ae) -> {
                        System.out.println(ae.getActionCommand());
                    });

                    p.add(button);
                } else {
                    JLabel label = new JLabel(new ImageIcon(icon));
                    p.add(label);
                }
                count++;
            }
        }
        JPanel center = new JPanel(new GridBagLayout());
        center.setBackground(Color.BLACK);
        center.add(p);
        JOptionPane.showMessageDialog(null, center);
    }

    public static void main(String[] args) throws Exception {
        URL url = new URL("http://i.stack.imgur.com/SNN04.png");
        final BufferedImage bi = ImageIO.read(url);
        SwingUtilities.invokeLater(() -> {
            new CompassButtons(bi);
        });
    }
}