package timerdemo;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author ottp
 * @version 1.0
 */
public class Gui extends JFrame {

    private JLabel jLabel;
    private Timer timer;
    private boolean chromeShown;

    public Gui() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        JPanel panel = new JPanel(new BorderLayout());
        jLabel = new JLabel(new ImageIcon("/home/ottp/Downloads/chrome.png"));
        chromeShown = true;

        panel.add(jLabel);
        timer = new Timer(5000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(chromeShown) {
                    jLabel.setIcon(new ImageIcon("/home/ottp/Downloads/ok.png"));
                    chromeShown = false;
                } else {
                    jLabel.setIcon(new ImageIcon("/home/ottp/Downloads/chrome.png"));
                    chromeShown = true;
                }
            }
        });
        timer.start();

        this.getContentPane().add(panel);
        this.setVisible(true);
    }
}