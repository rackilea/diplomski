import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;

@SuppressWarnings("serial")
public class MyTimer2 extends JPanel implements GuiTimer {
    private static final String TIME_FORMAT = "%03d:%03d";
    private static final int EXTRA_WIDTH = 50;
    private JLabel timerLabel = new JLabel();
    private TimerControl timerControl = new TimerControl(this);

    public MyTimer2() {
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Time:"));
        topPanel.add(timerLabel);

        JPanel centerPanel = new JPanel();
        centerPanel.add(new JButton(timerControl.getStartAction()));
        centerPanel.add(new JButton(timerControl.getStopAction()));

        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.PAGE_START);
        add(centerPanel, BorderLayout.CENTER);

        setDeltaTime(0);
    }

    @Override
    public void setDeltaTime(int delta) {
        int secs = (int) delta / 1000;
        int mSecs = (int) delta % 1000;
        timerLabel.setText(String.format(TIME_FORMAT, secs, mSecs));
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension superSz = super.getPreferredSize();
        if (isPreferredSizeSet()) {
            return superSz;
        }
        int prefW = superSz.width + EXTRA_WIDTH;
        int prefH = superSz.height;
        return new Dimension(prefW, prefH);
    }

    private static void createAndShowGui() {
        MyTimer2 mainPanel = new MyTimer2();

        JFrame frame = new JFrame("MyTimer2");
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

interface GuiTimer {
    public abstract void setDeltaTime(int delta);
}

@SuppressWarnings("serial")
class TimerControl {
    private static final int TIMER_DELAY = 10;
    private long startTime = 0;
    private long pauseTime = 0;
    private Timer timer;
    private GuiTimer gui;
    private StartAction startAction = new StartAction();
    private StopAction stopAction = new StopAction();

    public TimerControl(GuiTimer gui) {
        this.gui = gui;
    }

    public Action getStopAction() {
        return stopAction;
    }

    public Action getStartAction() {
        return startAction;
    }

    enum State {
        START("Start", KeyEvent.VK_S), 
        PAUSE("Pause", KeyEvent.VK_P);
        private String text;
        private int mnemonic;

        private State(String text, int mnemonic) {
            this.text = text;
            this.mnemonic = mnemonic;
        }

        public String getText() {
            return text;
        }

        public int getMnemonic() {
            return mnemonic;
        }
    };

    private class StartAction extends AbstractAction {
        private State state;

        public StartAction() {
            setState(State.START);
        }

        public final void setState(State state) {
            this.state = state;
            putValue(NAME, state.getText());
            putValue(MNEMONIC_KEY, state.getMnemonic());
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (state == State.START) {
                if (timer != null && timer.isRunning()) {
                    return; // the timer's already running
                }
                setState(State.PAUSE);
                if (startTime <= 0) {
                    startTime = System.currentTimeMillis();
                    timer = new Timer(TIMER_DELAY, new TimerListener());
                } else {
                    startTime += System.currentTimeMillis() - pauseTime;
                }
                timer.start();
            } else if (state == State.PAUSE) {
                setState(State.START);
                pauseTime = System.currentTimeMillis();
                timer.stop();
            }
        }
    }

    private class StopAction extends AbstractAction {
        public StopAction() {
            super("Stop");
            int mnemonic = KeyEvent.VK_T;
            putValue(MNEMONIC_KEY, mnemonic);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (timer == null) {
                return;
            }
            timer.stop();
            startAction.setState(State.START);
            startTime = 0;
        }
    }

    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            long time = System.currentTimeMillis();
            long delta = time - startTime;
            gui.setDeltaTime((int) delta); 
        }
    }

}