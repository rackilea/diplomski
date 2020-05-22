import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Formatter;

import javax.swing.*;

@SuppressWarnings("serial")
public class CountDownTimer extends JPanel {
    private static final String FORMAT = "%02d";
    private static final Color[] TIMER_COLORS = {Color.BLACK, Color.WHITE};
    private static final int LABEL_PTS = 90;
    private static final Font TIMER_LABEL_FONT = new Font("Times New Roman", Font.BOLD, LABEL_PTS);
    private static final int PREF_W = 600;
    private static final int PREF_H = PREF_W;
    private static final int TIMER_DELAY = 100;
    public static final int FLASH_TIME = 6;
    private JLabel timerLabel = new JLabel("");
    private Timer timer;
    private int timerColorIndex = 0;

    public CountDownTimer(int seconds) {
        setTimerCount(seconds);
        setLayout(new GridBagLayout());
        add(timerLabel);

        timer  = new Timer(TIMER_DELAY, new TimerListener(seconds));

        timer.start();
    }

    public final void setTimerCount(int count) {
        String text = String.format(FORMAT, count);
        timerLabel.setText(text);
        timerLabel.setFont(TIMER_LABEL_FONT);
    }

    public void flash() {
        timerColorIndex++;
        timerColorIndex %= TIMER_COLORS.length;
        timerLabel.setForeground(TIMER_COLORS[timerColorIndex]);
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    private class TimerListener implements ActionListener {
        private int mSeconds;

        public TimerListener(int secondsLeft) {
            this.mSeconds = 1000 * secondsLeft;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            mSeconds -= TIMER_DELAY;
            int seconds = (mSeconds + 999) / 1000;
            if (seconds < FLASH_TIME) {
                flash();
            }
            setTimerCount(seconds);
            if (seconds == 0) {
                ((Timer) e.getSource()).stop();
            }
        }
    }

    private static void createAndShowGui() {
        int seconds = 20;
        CountDownTimer mainPanel = new CountDownTimer(20);

        JFrame frame = new JFrame("CountDownTimer");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGui();
        });
    }
}