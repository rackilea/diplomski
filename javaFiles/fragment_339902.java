import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.Timer;

public class StartGUI extends JFrame {

    private JTextField jTime = new JTextField(10);
    private Timer timer = createTimer(1000);

    public StartGUI() {
        jTime.setEditable(false);

        add(jTime);
        setLayout(new GridBagLayout());
        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private Timer createTimer(int delay) {
        Timer timer = new Timer(delay, new ActionListener(){
            Time counter = new Time(30);
            public void actionPerformed(ActionEvent e) {
                if (counter.getTime() == 0) {
                    ((Timer)e.getSource()).stop();
                    jTime.setText("Times up!");
                } else {
                    jTime.setText("Time left: " + counter.getTime());
                    counter.decTime();
                }
            }
        });
        timer.setInitialDelay(0);
        return timer;
    }

    private Timer getTimer() {
        return timer;
    }

    static class Time {
        int time = 1000;
        public Time(int time) {
            this.time = time;
        }
        void decTime() {
            time--;
        }
        int getTime() {
            return time;
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                StartGUI start = new StartGUI();
                start.setVisible(true);
                start.getTimer().start();
            }
        });
    }
}