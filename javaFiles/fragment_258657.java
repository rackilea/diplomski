import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.WindowConstants;

public class TimerTest {

    public static void main(String[] args) {
        final JFrame frm = new JFrame("Countdown");
        final JLabel countdownLabel = new JLabel("03:00");
        final Timer t = new Timer(1000, new ActionListener() {
            int time = 180;
            @Override
            public void actionPerformed(ActionEvent e) {
                time--;
                countdownLabel.setText(format(time / 60) + ":" + format(time % 60));
                if (time == 0) {
                    final Timer timer = (Timer) e.getSource();
                    timer.stop();
                }
            }
        });
        frm.add(countdownLabel);
        t.start();
        frm.pack();
        frm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frm.setVisible(true);
    }

    private static String format(int i) {
        String result = String.valueOf(i);
        if (result.length() == 1) {
            result = "0" + result;
        }
        return result;
    }
}