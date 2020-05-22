import java.awt.BorderLayout;
import java.awt.Dialog.ModalityType;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class SwingWorkerExample2 {

    private static void createAndShowGui() {
        SWEx2MainPanel mainPanel = new SWEx2MainPanel();

        JFrame frame = new JFrame("SwingWorker Example");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}

@SuppressWarnings("serial")
class SWEx2MainPanel extends JPanel {
    public static final ModalityType DLG_MODALITY_TYPE = ModalityType.MODELESS;
    private JTextArea statusArea = new JTextArea(15, 30);
    private JDialog workerDialog;
    private SWEx2WorkerPanel workerPanel = new SWEx2WorkerPanel();

    public SWEx2MainPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(new JButton(new ShowWorkerDialogAction()));
        statusArea.setFocusable(false);
        JScrollPane scrollPane = new JScrollPane(statusArea);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setLayout(new BorderLayout(5, 5));
        add(scrollPane);
        add(buttonPanel, BorderLayout.PAGE_END);

        workerPanel.addPropertyChangeListener(new WorkerPanelListener());
    }

    private class WorkerPanelListener implements PropertyChangeListener {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            // the above percolates from the SwingWorker to the containing
            // JPanel
            if (evt.getNewValue() == SwingWorker.StateValue.DONE) {
                int processState = workerPanel.getProcessStatus();
                statusArea.append("Process State: " + processState + "\n");
            }
        }
    }

    private class ShowWorkerDialogAction extends AbstractAction {
        public ShowWorkerDialogAction() {
            super("Show Worker");
            putValue(MNEMONIC_KEY, KeyEvent.VK_S);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (workerDialog == null) {
                Window window = SwingUtilities.getWindowAncestor(statusArea);
                workerDialog = new JDialog(window, "Worker Dialog", DLG_MODALITY_TYPE);
                workerDialog.add(workerPanel);
                workerDialog.pack();
                workerDialog.setLocationByPlatform(true);
            } else if (workerDialog.isVisible()) {
                // dialog is still visible -- do nothing
                return;
            }
            workerDialog.setVisible(true);
        }
    }
}

// class that holds the JPanel that does background communication
@SuppressWarnings("serial")
class SWEx2WorkerPanel extends JPanel {
    private final JLabel statusLabel = new JLabel("Status: ", JLabel.CENTER);
    private final JTextArea textArea = new JTextArea(20, 30);
    private StartAction startAction = new StartAction("Start", KeyEvent.VK_S);
    private StopAction stopAction = new StopAction("Stop", KeyEvent.VK_T);
    private JProgressBar bar = new JProgressBar();
    private BackgroundTask backgroundTask;
    private int processStatus;

    public SWEx2WorkerPanel() {
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setLayout(new BorderLayout(5, 5));

        textArea.setFocusable(false);
        JScrollPane sp = new JScrollPane();
        sp.setBorder(BorderFactory.createTitledBorder("Output: "));
        sp.setViewportView(textArea);

        stopAction.setEnabled(false);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(new JButton(startAction));
        buttonPanel.add(new JButton(stopAction));
        buttonPanel.add(bar);

        add(statusLabel, BorderLayout.PAGE_START);
        add(sp, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.PAGE_END);
    }

    public void startProcess() {
        if (backgroundTask != null && !backgroundTask.isDone()) {
            return; // background task not yet done
        }
        textArea.setText("");
        startAction.setEnabled(false);
        stopAction.setEnabled(true);
        backgroundTask = new BackgroundTask();
        backgroundTask.addPropertyChangeListener(new BGTaskListener());
        backgroundTask.execute();
        bar.setIndeterminate(true);
    }

    public void cancelProcess() {
        if (backgroundTask != null && !backgroundTask.isDone()) {
            backgroundTask.cancel(true);
        }
    }

    public void processStopped() {
        statusLabel.setText((backgroundTask.getState()).toString() + " "
                + processStatus);
        stopAction.setEnabled(false);
        startAction.setEnabled(true);
        bar.setIndeterminate(false);

        // Window thisWindow = SwingUtilities.getWindowAncestor(textArea);
        // thisWindow.dispose();
    }

    public int getProcessStatus() {
        return processStatus;
    }

    private class BGTaskListener implements PropertyChangeListener {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            if (evt.getNewValue() == SwingWorker.StateValue.DONE) {
                processStopped();
            }

            // percolate this listener up to the main JPanel's Prop Chng
            // Listener
            SWEx2WorkerPanel.this.firePropertyChange(evt.getPropertyName(), evt.getOldValue(),
                    evt.getNewValue());
        }
    }

    private class BackgroundTask extends SwingWorker<Integer, String> {

        @Override
        protected Integer doInBackground() throws Exception {
            List<String> list = new ArrayList<>();
            list.add("ping");
            String name = System.getProperty("os.name");
            if (name.startsWith("Win")) {
                list.add("-n");
            } else {
                list.add("-c");
            }
            list.add("5");
            list.add("google.com");
            try {
                ProcessBuilder pb = new ProcessBuilder(list);
                pb.redirectErrorStream(true);
                Process p = pb.start();
                String s;
                BufferedReader stdout = new BufferedReader(
                        new InputStreamReader(p.getInputStream()));
                while ((s = stdout.readLine()) != null && !isCancelled()) {
                    publish(s);
                }
                if (!isCancelled()) {
                    processStatus = p.waitFor();
                }
                p.getInputStream().close();
                p.getOutputStream().close();
                p.getErrorStream().close();
                p.destroy();
            } catch (IOException | InterruptedException ex) {
                ex.printStackTrace(System.err);
            }
            return processStatus;
        }

        @Override
        protected void process(java.util.List<String> messages) {
            statusLabel.setText((this.getState()).toString());
            for (String message : messages) {
                textArea.append(message + "\n");
            }
        }

    }

    private class StartAction extends AbstractAction {
        public StartAction(String name, int mnemonic) {
            super(name);
            putValue(MNEMONIC_KEY, mnemonic);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            startProcess();
        }
    }

    private class StopAction extends AbstractAction {
        public StopAction(String name, int mnemonic) {
            super(name);
            putValue(MNEMONIC_KEY, mnemonic);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            cancelProcess();
        }
    }

}