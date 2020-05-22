import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Game {

    public static void main(String[] args) {
        new Game();
    }

    public Game() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                try {
                    URL url = new URL("https://s-media-cache-ak0.pinimg.com/originals/e8/e4/02/e8e4028941eb06f2fd5c10f44bfc5e1b.gif");
                    Icon icon = new ImageIcon(url);
                    JLabel label = new JLabel(icon);

                    JFrame f = new JFrame("Trippy");
                    f.getContentPane().add(label);
                    f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    f.pack();
                    f.setLocationRelativeTo(null);
                    f.setVisible(true);

                    Timer timer = new Timer(5000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            f.dispose();
                            //This is the part i want the .gif to end. Instead, it just runs in the background.
                            JOptionPane.showMessageDialog(null, "You have traveled through space and time!");
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();

                } catch (MalformedURLException exp) {
                    exp.printStackTrace();
                }
            }
        });
    }
}