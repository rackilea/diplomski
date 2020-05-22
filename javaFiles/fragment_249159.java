import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Frame1 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                final JFrame frame = new JFrame();
                frame.getContentPane().setBackground(
                        new Color(0, 0, 0));
                Timer timer = new Timer(10, new ActionListener() {
                    int num = 0;
                    public void actionPerformed(ActionEvent e) {
                        if (num > 255) {
                            ((Timer) e.getSource()).stop();
                        } else {
                            frame.getContentPane().setBackground(
                                    new Color(num, num, num));
                            num++;
                        }
                    }
                });
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(300, 300);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                timer.start();
            }
        });
    }
}