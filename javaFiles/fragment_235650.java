import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;

@SuppressWarnings("serial")
public class TaskEx extends JPanel {
    private int taskLeft = 10;
    private JLabel taskCountLabel = new JLabel(String.valueOf(taskLeft));

    public TaskEx() {
        JPanel northPanel = new JPanel();
        northPanel.add(new JLabel("Tasks Left:"));
        northPanel.add(taskCountLabel);

        JPanel centerPanel = new JPanel();
        centerPanel.add(new JButton(new Handler("Push Me")));

        setLayout(new BorderLayout());
        add(northPanel, BorderLayout.PAGE_START);
        add(centerPanel, BorderLayout.CENTER);
    }

    public void doTask() {
        taskCountLabel.setText(String.valueOf(taskLeft));
    }

    private static void createAndShowGui() {
        TaskEx mainPanel = new TaskEx();

        JFrame frame = new JFrame("Task Example");
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

    private class Handler extends AbstractAction {
        public Handler(String name) {
            super(name);
            putValue(MNEMONIC_KEY, (int) name.charAt(0));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (taskLeft > 0) {
                taskLeft--;
                doTask();
            }
        }
    }

}