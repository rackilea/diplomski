import java.awt.image.BufferedImage;
import javax.swing.*;

public class FileChooserIcon {

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    // see nice icons in chooser!
                    UIManager.setLookAndFeel(
                            UIManager.getSystemLookAndFeelClassName());
                } catch (Exception useDefault) {}
                JLabel ui = new JLabel("Big Space");
                ui.setBorder(new javax.swing.EmptyBorder(40, 200, 40, 200));

                JFrame f = new JFrame("Show file chooser icon");
                f.setIconImage(new BufferedImage(
                        20, 20, BufferedImage.TYPE_INT_RGB));
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setContentPane(ui);
                f.pack();
                f.setLocationByPlatform(true);
                f.setVisible(true);

                JFileChooser jfc = new JFileChooser();
                jfc.showOpenDialog(f); // use frame icon!
            }
        };
        SwingUtilities.invokeLater(r);
    }
}