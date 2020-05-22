import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MyRadioButton {

    private JFrame frame = new JFrame("RadioRadio");
    private JLabel timerl = new JLabel("Press Button to start");
    private JPanel butp = new JPanel();
    private JButton button = new JButton("Start Exam");
    private Timer mytimer;
    private String ss = "Time Remaining %02d Seconds!";
    private int elapsedSeconds = 0;
    private int total = 10;

    public MyRadioButton() {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (mytimer != null && mytimer.isRunning()) {
                    mytimer.stop();
                    elapsedSeconds = 0;
                    timerl.setText("Exam Terminated");
                } else {
                    mytimer = new Timer(1000, new TimerListener());
                    mytimer.start();
                    String t = String.format(ss, total);
                    timerl.setText(t);
                }
            }
        });
        butp.add(button);
        butp.add(timerl);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(butp);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }

    private class TimerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            elapsedSeconds++;
            if (elapsedSeconds == total) {
                mytimer.stop();
                elapsedSeconds = 0;
                timerl.setText("Time Up");
            } else {
                String t = String.format(ss, total - elapsedSeconds);
                timerl.setText(t);
            }
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MyRadioButton r = new MyRadioButton();
            }
        });
    }
}