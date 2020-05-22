import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Dialog.ModalityType;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import static javax.swing.Action.MNEMONIC_KEY;

public class SwingWorkerExample2 {
    private JDialog modalDialog; // !! a modal JDialog
    private ExecuteFrame backgroundTask;
    private Runnable myCallback; // !!

    private class properyListener implements PropertyChangeListener {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            if (evt.getNewValue() == SwingWorker.StateValue.DONE) {
                int processState = backgroundTask.getProcessStatus();
                System.out.println("Process State: " + processState + "\n");

                // !! added
                myCallback.run(); // simply run it. No need to place into a new thread
            }
        }
    }

    // !! set myCallback field. This could also be done as a parameter to 
    // !! the displayGUI(Runnable myCallback) method  if desired
    public SwingWorkerExample2(Runnable myCallback) {
        this.myCallback = myCallback;
    }

    private void displayGUI() {
        // !! create it as a modal dialog
        modalDialog = new JDialog(null, "Swing Worker Example", ModalityType.APPLICATION_MODAL);
        modalDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); // !!
        backgroundTask = new ExecuteFrame();
        modalDialog.add(backgroundTask);
        backgroundTask.addPropertyChangeListener(new properyListener());
        modalDialog.pack();
        modalDialog.setLocationByPlatform(true);
        modalDialog.setVisible(true);
        backgroundTask.startProcess();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                System.out.println("Here I start");
                Runnable myCallback = new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("This is being displayed from a Runnable");
                    }
                };

                // pass callback Runnable into SwingWorkerExample2's constructor
                new SwingWorkerExample2(myCallback).displayGUI(); // !! not wrapped in a Runnable
                System.out.println("This is displayed after the dialog is no longer visible");
            }
        });
    }
}

@SuppressWarnings("serial")
class ExecuteFrame2 extends JPanel {
    private final JLabel statusLabel = new JLabel("Status: ", JLabel.CENTER);
    private final JTextArea textArea = new JTextArea(20, 30);
    private StartAction startAction = new StartAction("Start", KeyEvent.VK_S);
    private StopAction stopAction = new StopAction("Stop", KeyEvent.VK_T);
    private JProgressBar bar = new JProgressBar();
    private BackgroundTask backgroundTask;
    private int processStatus;

    public ExecuteFrame2() {
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
        statusLabel.setText((backgroundTask.getState()).toString() + " " + processStatus);
        stopAction.setEnabled(false);
        startAction.setEnabled(true);
        bar.setIndeterminate(false);
        // Window thisWindow = SwingUtilities.getWindowAncestor(textArea);
        // thisWindow.dispose();
    }

    public int getProcessStatus() {
        return processStatus;
    }

    public class BGTaskListener implements PropertyChangeListener {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            if (evt.getNewValue() == SwingWorker.StateValue.DONE) {
                processStopped();
            }
            // percolate this listener up to the main JPanel's Prop Chng
            // Listener
            ExecuteFrame2.this.firePropertyChange(evt.getPropertyName(), evt.getOldValue(),
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