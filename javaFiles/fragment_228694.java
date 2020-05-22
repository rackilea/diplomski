import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class BackGroundImage {

    private JComponent ui = null;

    BackGroundImage() {
        initUI();
    }

    public void initUI() {
        if (ui != null) {
            return;
        }

        ui = new JPanel(new GridLayout(0, 1));
        ui.setBorder(new EmptyBorder(4, 4, 4, 4));

        try {
            BufferedImage bi1 = ImageIO.read(
                    new URL ("http://i.stack.imgur.com/OVOg3.jpg"));
            BackgroundPanel bp = new BackgroundPanel(bi1);
            ui.add(bp);
            bp.setLayout(new GridBagLayout());
            JLabel l1 = new JLabel("Using BackgroundPanel");
            Font f = l1.getFont();
            l1.setFont(f.deriveFont(32f));
            l1.setForeground(Color.RED);
            bp.add(l1);
            BufferedImage bi2 = ImageIO.read(
                    new URL ("http://i.stack.imgur.com/lxthA.jpg"));
            JLabel l = new JLabel(new ImageIcon(bi2));
            ui.add(l);
            l.setLayout(new GridBagLayout());
            JLabel l2 = new JLabel("Using JLabel");
            l2.setFont(f.deriveFont(32f));
            l2.setForeground(Color.RED);
            l.add(l2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JComponent getUI() {
        return ui;
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                BackGroundImage o = new BackGroundImage();

                JFrame f = new JFrame("BackgroundPanel");
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setLocationByPlatform(true);

                f.setContentPane(o.getUI());
                f.pack();
                f.setMinimumSize(f.getSize());

                f.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(r);
    }
}

class BackgroundPanel extends JPanel {

    BufferedImage image;

    public BackgroundPanel(BufferedImage image) {
        this.image = image;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension d = super.getPreferredSize();

        int w = d.width > image.getWidth() ? d.width : image.getWidth();
        int h = d.height > image.getHeight() ? d.height : image.getHeight();

        return new Dimension(w, h);
    }
}