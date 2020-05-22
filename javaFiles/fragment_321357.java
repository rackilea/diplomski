import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ScreenShot {

    public static void main(String[] args) {
        new ScreenShot();
    }

    public ScreenShot() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                final JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());

                JButton capture = new JButton("Snap shot");
                capture.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            Robot bot = new Robot();
                            BufferedImage frameImage = bot.createScreenCapture(frame.getBounds());
                            JRootPane rootPane = frame.getRootPane();
                            Rectangle bounds = new Rectangle(rootPane.getSize());
                            bounds.setLocation(rootPane.getLocationOnScreen());
                            BufferedImage contentsImage = bot.createScreenCapture(bounds);

                            JPanel panel = new JPanel(new GridLayout(1, 2));
                            panel.add(new JLabel(new ImageIcon(frameImage)));
                            panel.add(new JLabel(new ImageIcon(contentsImage)));

                            JOptionPane.showMessageDialog(frame, panel);

                        } catch (AWTException ex) {
                            ex.printStackTrace();
                        }
                    }
                });

                frame.add(capture, BorderLayout.SOUTH);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {

            setLayout(new BorderLayout());

            try {
                BufferedImage img = ImageIO.read(new File("C:\\Users\\shane\\Dropbox\\Ponies\\sillydash-small.png"));
                JLabel label = new JLabel(new ImageIcon(img));
                add(label);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }

    }

}