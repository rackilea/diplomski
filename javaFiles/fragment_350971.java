import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class BackgroundFrameImage {

    public static void main(String[] args) {
        new BackgroundFrameImage();
    }

    public BackgroundFrameImage() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                try {
                    JLabel label = new JLabel(new ImageIcon(ImageIO.read(...))));

                    JFrame frame = new JFrame("Testing");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setContentPane(label);
                    frame.setLayout(new BorderLayout());
                    JLabel text = new JLabel("Hello from the foreground");
                    text.setForeground(Color.WHITE);
                    text.setHorizontalAlignment(JLabel.CENTER);
                    frame.add(text);
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (IOException | HeadlessException exp) {
                    exp.printStackTrace();
                }
            }
        });
    }

}