import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

@SuppressWarnings("serial")
public class MyApp extends JPanel {
    // display the date/time
    private static final String DATE_FORMAT = "HH:mm:ss  dd-MM-yyyy";
    private static final DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);

    // timer updates measures seconds, but updates every 0.2 sec's to be sure
    private static final int TIMER_DELAY = 200;

    // JLabel that shows the date/time
    private JLabel timeLabel = new JLabel("", SwingConstants.CENTER);

    // JButton's Action / listener. This starts long-running data processing
    private Action dataProcessAction = new DataProcessAction("Process Data");

    // the SwingWorker that the above Action executes:
    private LongRunningSwProcess longRunningProcess;

    // label to display the count coming from the process above
    private JLabel countLabel = new JLabel("00");

    public MyApp() {
        // create a simple GUI
        JPanel dataProcessingPanel = new JPanel();
        dataProcessingPanel.add(new JButton(dataProcessAction)); // button that starts process
        dataProcessingPanel.add(new JLabel("Count:"));
        dataProcessingPanel.add(countLabel);        

        setLayout(new BorderLayout());
        add(timeLabel, BorderLayout.PAGE_START);
        add(dataProcessingPanel);
        showTimeLabelCurrentTime();
        // create and start Swing Timer
        new Timer(TIMER_DELAY, new TimerListener()).start(); 
    }

    // display count from swing worker
    public void setCount(int newValue) {
        countLabel.setText(String.format("%02d", newValue));
    }

    // clean up code after SwingWorker finishes
    public void longRunningProcessDone() {
        // re-enable JButton's action
        dataProcessAction.setEnabled(true);
        if (longRunningProcess != null) {
            try {
                // handle any exceptions that might get thrown from the SW
                longRunningProcess.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    // display the current time in our timeLabel JLabel
    private void showTimeLabelCurrentTime() {
        long currentTime = System.currentTimeMillis();
        Date date = new Date(currentTime);
        timeLabel.setText(dateFormat.format(date));
    }

    // Timer's ActionListener is simple -- display the current time in the timeLabel
    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            showTimeLabelCurrentTime();
        }
    }

    // JButton's action. This starts the long-running SwingWorker
    private class DataProcessAction extends AbstractAction {

        public DataProcessAction(String name) {
            super(name);
            int mnemonic = (int) name.charAt(0);
            putValue(MNEMONIC_KEY, mnemonic);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            setEnabled(false); // first disable the button's action
            countLabel.setText("00"); // reset count label

            // then create SwingWorker and listen to its changes
            longRunningProcess = new LongRunningSwProcess();
            longRunningProcess.addPropertyChangeListener(new DataProcessListener());

            // execute the swingworker
            longRunningProcess.execute();
        }
    }

    // listen for state changes in our SwingWorker
    private class DataProcessListener implements PropertyChangeListener {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            if (evt.getPropertyName().equals(LongRunningSwProcess.COUNT)) {
                setCount((int)evt.getNewValue());
            } else if (evt.getNewValue() == SwingWorker.StateValue.DONE) {
                longRunningProcessDone();
            }
        }
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("My App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new MyApp());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}