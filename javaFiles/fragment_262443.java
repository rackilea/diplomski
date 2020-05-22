import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.*;

public class Prac2_StopWatch implements ActionListener {
    JFrame time;
    JLabel timeLabel;
    JButton startStop;
    JButton reset;
    StopWatch stThread;
    String prefix = "<html><h1><body>";
    String suffix = "</h1></body></html>";
    StopWatch myControl;

    Prac2_StopWatch() {
        time = new JFrame();

        time.setSize(275, 275);
        time.setTitle("Stop Watch");
        time.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        time.setLayout(new GridBagLayout());
        GridBagConstraints gridConst = new GridBagConstraints();

        timeLabel = new JLabel();
        timeLabel.setText(prefix + "00:00:000" + suffix);

        myControl = new StopWatch(timeLabel);
        new Thread(myControl).start(); // StopWatch should implement Runnable
        // myControl.start();

        startStop = new JButton();
        reset = new JButton();

        startStop.setActionCommand("Start");
        startStop.setText("Start");
        reset.setText("Reset");

        startStop.addActionListener(this);
        reset.addActionListener(this);

        gridConst.gridx = 0;
        gridConst.gridy = 0;
        time.add(startStop, gridConst);

        gridConst.gridx = 1;
        gridConst.gridy = 0;
        time.add(reset, gridConst);

        gridConst.gridx = 0;
        gridConst.gridy = 1;
        time.add(timeLabel, gridConst);

        time.setVisible(true);
    }

    public void actionPerformed(ActionEvent evt) {
        if (evt.getActionCommand().equalsIgnoreCase("Start")) {
            startStop.setActionCommand("Stop");
            startStop.setText("Stop");
            if (myControl.getCurMil() == -1)
                myControl.setCurMil(Calendar.getInstance().getTimeInMillis());
            else
                myControl.setCurMil(Calendar.getInstance().getTimeInMillis() - myControl.getDiff());
            myControl.count = true;

        } else if (evt.getActionCommand().equalsIgnoreCase("Stop")) {
            startStop.setActionCommand("Start");
            startStop.setText("Start");
            myControl.count = false;

        } else if (evt.getActionCommand().equalsIgnoreCase("Reset")) {
            startStop.setActionCommand("Start");
            startStop.setText("Start");
            myControl.count = false;
            myControl.setCurMil(-1);
            timeLabel.setText(prefix + "00:00:000" + suffix);
        }
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Prac2_StopWatch();
            }
        });

    }
}

class StopWatch implements Runnable {
    private long curMil;
    private long diff;
    private JLabel timeLabel;

    // *************** this is key ****************
    volatile boolean count; // !! *********************

    String prefix = "<html><body><h1>";
    String suffix = "</h1></body></html>";

    StopWatch(JLabel TimeLabel) {
        this.timeLabel = TimeLabel;
        this.count = false;
        this.curMil = -1;
    }

    public long getCurMil() {
        return curMil;
    }

    public void setCurMil(long curMil) {
        this.curMil = curMil;
    }

    public long getDiff() {
        return diff;
    }

    public void run() {
        while (true) {
            // System.out.println("Commenting this line will make stop watch useless");
            if (count) {
                diff = Calendar.getInstance().getTimeInMillis() - curMil;

                // make Swing changes **on** the event thread only
                SwingUtilities.invokeLater(() -> {
                    int mSec = (int) (diff % 1000);
                    int sec = (int) ((diff / 1000) % 60);
                    int min = (int) ((diff / (60 * 1000)) % 60);
                    String text = String.format("%s%02d:%02d:%03d%s", prefix, min, sec, mSec, suffix);
                    timeLabel.setText(text);
                });
                try {
                    Thread.sleep(1);  // ** actually 1 is OK **
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}