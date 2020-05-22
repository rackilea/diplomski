import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseWheelEvent;
import javax.swing.*;

@SuppressWarnings("serial")
public class NotifyWheelStopped extends JPanel {
    private static final int PREF_W = 400;
    private static final int PREF_H = PREF_W;
    private static final String WHEEL_STOPPED = "Wheel has stopped";
    private static final String WHEEL_MOVING = "Wheel is moving";
    public static final int TIMER_DELAY = 100;
    private JLabel notificationLabel = new JLabel(WHEEL_STOPPED, SwingConstants.CENTER);
    private WheelHandler wheelHandler = new WheelHandler();
    private Timer wheelMovementTimer;

    public NotifyWheelStopped() {
        add(notificationLabel);
        addMouseWheelListener(wheelHandler);
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    private class WheelHandler extends MouseAdapter {
        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
            notificationLabel.setText(WHEEL_MOVING);
            if (wheelMovementTimer != null && wheelMovementTimer.isRunning()) {
                wheelMovementTimer.stop();
            }
            wheelMovementTimer = new Timer(TIMER_DELAY, new WheelMovementTimerActionListener());
            wheelMovementTimer.setRepeats(false);
            wheelMovementTimer.start();
        }
    }

    private class WheelMovementTimerActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            notificationLabel.setText(WHEEL_STOPPED);
        }
    }

    private static void createAndShowGui() {
        NotifyWheelStopped mainPanel = new NotifyWheelStopped();

        JFrame frame = new JFrame("NotifyWheelStopped");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}