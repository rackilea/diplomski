import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class Test extends JPanel {
    private JLabel         progressLabel  = new JLabel("0 %");
    private HeavyProcessor heavyProcessor = new HeavyProcessor();

    private static class HeavyProcessor extends Thread {
        private volatile int currentStatus = 0;

        @Override
        public void run() {
            for (int i = 0; i <= 100; i++) {
                currentStatus++;

                try {
                    Thread.currentThread().sleep(1000);
                } catch (InterruptedException e) {
                }
            }
        }

        public int getStatus() {
            return currentStatus;
        }
    }

    public Test() {
        this.add(progressLabel);
        this.heavyProcessor.start();

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        progressLabel.setText(String.valueOf(heavyProcessor.getStatus()) + " %");
                    }
                });
            }
        }, 0, 1000);
    }

    public static void main(String[] args) {
        JFrame window = new JFrame("Progressbar");
        window.setSize(200, 200);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(new Test());
    }
}