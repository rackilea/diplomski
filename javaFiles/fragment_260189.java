import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestJFrame implements ActionListener {
    private JProgressBar progress;
    private JButton startButton;
    private JButton testButton;
    private SwingWorker<Void, Integer> worker;

    public void initUI() {
        JFrame frame = new JFrame(TestJFrame.class.getSimpleName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        progress = new JProgressBar(0, 100);
        startButton = new JButton("Start work");
        testButton = new JButton("Test me while work is in progress");
        startButton.addActionListener(this);
        testButton.addActionListener(this);
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(startButton);
        buttonPanel.add(testButton);
        frame.add(buttonPanel, BorderLayout.NORTH);
        frame.add(progress, BorderLayout.SOUTH);
        frame.setSize(600, 400);
        frame.setVisible(true);
    }

    private void showTestDialog() {
        if (worker != null) {
            JOptionPane.showMessageDialog(testButton, "You made a test. See how I still respond while heavy job is in progress?");
        } else {
            JOptionPane.showMessageDialog(testButton,
                    "You made a test, but no job is progress. Hit the \"Start work\" button and hit me again after.");
        }
    }

    private void startWork() {
        if (worker != null) {
            return;
        }
        startButton.setEnabled(false);
        worker = new SwingWorker<Void, Integer>() {

            @Override
            protected Void doInBackground() throws Exception {
                // Outside EDT, we cannot modify the UI, but we can perform lengthy operations
                // without blocking the UI
                for (int i = 0; i < 10; i++) {
                    publish(i * 10);
                    Thread.sleep(1000);
                }
                return null;
            }

            @Override
            protected void process(List<Integer> chunks) {
                // Inside EDT, here we can modify the UI
                super.process(chunks);
                // We only care about the last one
                progress.setValue(chunks.get(chunks.size() - 1));
            }

            @Override
            protected void done() {
                // Inside EDT, he we can modify the UI
                super.done();
                progress.setValue(100);
                startButton.setEnabled(true);
                worker = null;
            }

        };
        worker.execute();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            startWork();
        } else if (e.getSource() == testButton) {
            showTestDialog();
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException,
            UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TestJFrame().initUI();
            }

        });
    }
}