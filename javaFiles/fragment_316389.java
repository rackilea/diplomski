import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class teset {

private static JFrame frame = new JFrame("FrameDemo");
private static JLabel time = new JLabel();

public static void main(String[] args) {

    frame.add(time);
    frame.pack();

    frame.setVisible(true);

    new Thread(new Runnable() {
        public void run() {
            try {
                updateTime();
            } catch (Exception ie) {
            }
        }
    }).start();
}

public static void updateTime() {
    try {
        while (true) {
            time.setText(new SimpleDateFormat("hh:mm:ss a").format(new java.util.Date()));
            Thread.currentThread().sleep(1000);
        }
    } catch (Exception e) {
        System.out.println("Exception in Thread Sleep : " + e);
    }
}