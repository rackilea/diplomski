import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.Timer;

public class StartGUI extends JFrame {

    static JTextField jTime = new JTextField(10);

    public StartGUI() {
        jTime.setEditable(false);
        add(jTime);
        setLayout(new GridBagLayout());
        setSize(200, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    static class Time {
        int time = 1000;
        void decTime() {
            time--;
        }
        int getTime() {
            return time;
        }
    }

    public static void main(String args[]) {
        Time counter = new Time();
        ActionListener actListner = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                counter.decTime();
                jTime.setText("Time left: " + counter.getTime());
            }
        };
        Timer timer = new Timer(1000, actListner);
        timer.start();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StartGUI().setVisible(true);
            }
        });
    }
}