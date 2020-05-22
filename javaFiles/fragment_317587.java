import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.logging.Logger;

public class FProgressDisplay extends JFrame {
    private final static Logger LOGGER = Logger.getLogger(FProgressDisplay.class.getName());
    private List<PanelTaskProgress> tasks;
    JTextArea txtLog;
    JButton btnNew;
    JButton btnAbort;
    JButton btnClose;
    static int i;
    JPanel taskPanel;

    public static void main(String[] args) {
        try {
            FProgressDisplay frame = new FProgressDisplay();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to initialize application.");
        }
    }
    /**
     * Create the frame.
     */
    public FProgressDisplay() {
        setTitle("Mask tool - Progress");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // should be done AFTER components are added
        //pack();
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        taskPanel = new JPanel();
        taskPanel.setLayout(new BoxLayout(taskPanel, BoxLayout.Y_AXIS));

        JPanel panel = new JPanel();
        getContentPane().add(panel);

        btnNew = new JButton("New");
        panel.add(btnNew);
        btnNew.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                addTask(++i, "Task " + i);
            }
        });

        btnAbort = new JButton("Abort");
        panel.add(btnAbort);

        btnClose = new JButton("Close");
        panel.add(btnClose);

        txtLog = new JTextArea();
        txtLog.setLineWrap(true);
        getContentPane().add(txtLog);

        tasks = new ArrayList<PanelTaskProgress>();

        JScrollPane scrollPane = new JScrollPane(taskPanel);
        getContentPane().add(scrollPane);

        for(i = 0; i < 10; i++) {
            addTask(i, "Task"+i);
        }
        pack();
    }

    public void addTask(long id, String fileName) {
        PanelTaskProgress newTaskPanel = new PanelTaskProgress(id, fileName);
        tasks.add(newTaskPanel);
        taskPanel.add(newTaskPanel);
        validate();
        //repaint();
        LOGGER.info("Added new panel");
    }

    public class PanelTaskProgress extends JPanel {
        private static final long serialVersionUID = 1L;
        JLabel lblTaskDescription;
        JLabel lblProgress;
        private long id;
        /**
         * Create the panel.
         */
        public PanelTaskProgress(long id, String fileName) {
            try {
                //setLayout(null);

                lblTaskDescription = new JLabel(id + " " + fileName);
                //lblTaskDescription.setPreferredSize(new Dimension(632, 14));
                add(lblTaskDescription);

                lblProgress = new JLabel("0%");
                lblProgress.setHorizontalAlignment(SwingConstants.CENTER);
                //lblProgress.setBounds(664, 11, 51, 14);
                add(lblProgress);

                LOGGER.info("Created new panel; Id: " + id + "; File: " + fileName);
            } catch (Exception e) {
                LOGGER.severe("Error creating new panel; " + e.getMessage());
            }
        }
    }
}