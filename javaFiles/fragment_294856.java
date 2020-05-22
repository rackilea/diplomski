import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Spil {

    private static final ImageIcon img1 = new ImageIcon("index.jpeg");
    private static final ImageIcon img2 = new ImageIcon("run.jpeg");

    boolean bool = false;

    public void run() {
        JFrame frame = new JFrame("STICKMAN");
        frame.setVisible(true);
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel(img1);

        frame.add(label);
        Timer t = new Timer(10, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (bool) {
                    label.setIcon(img1);
                } else {
                    label.setIcon(img2);
                }
                bool=!bool;
            }
        });
        t.start();

    }

    public static void main(String[] args) {
        Spil run = new Spil();
        run.run();
    }
}