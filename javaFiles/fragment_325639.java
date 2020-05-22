import java.awt.*;
import java.awt.image.*;
import java.io.IOException;
import javax.swing.*;
import javax.imageio.*;
import java.net.URL;

public class ImageGrid {

    private JComponent ui = null;
    String imageURL = "https://i.stack.imgur.com/DlSgb.png";

    ImageGrid() {
        try {
            BufferedImage img = ImageIO.read(new URL(imageURL));
            BufferedImage subImg = img.getSubimage(2, 2, 64, 64);
            initUI(subImg);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    final public void initUI(Image img) {
        ui = new JPanel(new GridLayout(0,8));

        ImageIcon icon = new ImageIcon(img);
        for (int ii=0; ii<32; ii++) {
            ui.add(new JLabel(icon));
        }
    }

    public JComponent getUI() {
        return ui;
    }

    public static void main(String[] args) {
        Runnable r = () -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception useDefault) {
            }
            ImageGrid o = new ImageGrid();

            JFrame f = new JFrame(o.getClass().getSimpleName());
            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            f.setLocationByPlatform(true);

            f.setContentPane(o.getUI());
            f.pack();
            f.setMinimumSize(f.getSize());

            f.setVisible(true);
        };
        SwingUtilities.invokeLater(r);
    }
}