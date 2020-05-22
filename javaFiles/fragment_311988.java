import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

@SuppressWarnings("serial")
public class ProgressMcve extends JPanel {
    private JProgressBar progressBar = new JProgressBar(0, 100);
    private CopyAction copyAction = new CopyAction();

    public ProgressMcve() {
        progressBar.setStringPainted(true);

        add(progressBar);
        add(new JButton(copyAction));
    }

    private class CopyAction extends AbstractAction {
        public CopyAction() {
            super("Copy");
            putValue(MNEMONIC_KEY, KeyEvent.VK_C);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            setEnabled(false);
            progressBar.setValue(0);
            MockCopyService copyService = new MockCopyService();
            copyService.addPropertyChangeListener(new CopyServiceListener());
            copyService.execute();
        }
    }

    private class CopyServiceListener implements PropertyChangeListener {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            if ("progress".equals(evt.getPropertyName())) {
                int progress = (int) evt.getNewValue();
                progressBar.setValue(progress);
            } else if (SwingWorker.StateValue.DONE == evt.getNewValue()) {
                progressBar.setValue(100);
                progressBar.setString("Done");
                copyAction.setEnabled(true);
                try {
                    ((MockCopyService) evt.getSource()).get();
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void createAndShowGui() {
        ProgressMcve mainPanel = new ProgressMcve();

        JFrame frame = new JFrame("ProgressMcve");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}