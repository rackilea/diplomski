import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    try {
                        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                        ex.printStackTrace();
                    }

                    BufferedImage img = ImageIO.read(getClass().getResource("/Chrome.png"));
                    ImageIcon icon = new ImageIcon(img);
                    JLabel label = new JLabel(icon);

                    JFrame frame = new JFrame("Testing");
                    frame.setUndecorated(true);
                    frame.setBackground(new Color(0, 0, 0, 0));
                    frame.add(label);
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);

                    Timer timer = new Timer(40, new ActionListener() {
                        float opacity = 1.0f;
                        float delta = 0.05f;

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            opacity -= delta;
                            if (opacity < 0.0f) {
                                opacity = 0.0f;
                                ((Timer)(e.getSource())).stop();
                                frame.dispose();
                            }
                            frame.setOpacity(opacity);
                        }
                    });
                    timer.setInitialDelay(2000);
                    timer.start();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

}