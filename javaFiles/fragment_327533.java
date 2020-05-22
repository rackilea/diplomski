import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private JPanel contentPane;
        private List<EmployeeHistory> histories;

        public TestPane() {
            histories = new ArrayList<>(25);
            setLayout(new BorderLayout());

            contentPane = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.weighty = 1;
            contentPane.add(new JPanel(), gbc);

            JScrollPane scrollPane = new JScrollPane(contentPane);
            add(scrollPane);

            ActionPane actionPane = new ActionPane();
            actionPane.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.gridwidth = GridBagConstraints.REMAINDER;
                    gbc.weightx = 1;
                    gbc.fill = GridBagConstraints.HORIZONTAL;

                    EmployeeHistory history = new EmployeeHistory();
                    histories.add(history);
                    HistoryPane pane = new HistoryPane(history);
                    pane.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            pane.removeActionListener(this);
                            histories.remove(pane.getHistory());
                            contentPane.remove(pane);
                            contentPane.revalidate();
                            contentPane.repaint();
                        }
                    });
                    contentPane.add(pane, gbc, contentPane.getComponentCount() - 1);
                    contentPane.revalidate();
                    contentPane.repaint();
                }
            });
            add(actionPane, BorderLayout.SOUTH);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 400);
        }

    }

    public class ActionPane extends JPanel {

        private JButton btn;

        public ActionPane() {
            setLayout(new GridBagLayout());
            btn = new JButton("Add");
            add(btn);
        }

        public void addActionListener(ActionListener listener) {
            btn.addActionListener(listener);
        }

        public void removeActionListener(ActionListener listener) {
            btn.removeActionListener(listener);
        }

    }

    public class EmployeeHistory {

        private String role;
        private String duration;
        private String employer;

        public EmployeeHistory() {
        }

        public EmployeeHistory(String role, String duration, String employer) {
            this.role = role;
            this.duration = duration;
            this.employer = employer;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public String getEmployer() {
            return employer;
        }

        public void setEmployer(String employer) {
            this.employer = employer;
        }

    }

    public class HistoryPane extends JPanel {

        private final JTextField txtRole;
        private final JTextField txtDuration;
        private final JTextField txtEmployer;

        private final JButton removeButton;

        private EmployeeHistory history;

        public HistoryPane(EmployeeHistory history) {
            // This is what you should use when you want to populate
            // the view or properties of the UI are changed
            this.history = history;
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;

            JLabel lblRoleHeld = new JLabel("Role Held:");
            add(lblRoleHeld, gbc);

            gbc.gridx++;
            txtRole = new JTextField();
            txtRole.setText("role");
            add(txtRole, gbc);
            txtRole.setColumns(10);

            gbc.gridx = 0;
            gbc.gridy++;
            JLabel lblDuration = new JLabel("Duration:");
            add(lblDuration, gbc);

            gbc.gridx++;
            txtDuration = new JTextField();
            txtDuration.setText("duration");
            add(txtDuration, gbc);
            txtDuration.setColumns(10);

            gbc.gridx = 0;
            gbc.gridy++;
            JLabel lblEmployer = new JLabel("Employer:");
            add(lblEmployer, gbc);

            gbc.gridx++;
            txtEmployer = new JTextField();
            txtEmployer.setText("employer");
            add(txtEmployer, gbc);
            txtEmployer.setColumns(10);

            gbc.gridx = 0;
            gbc.gridy++;
            gbc.gridwidth = GridBagConstraints.REMAINDER;

            removeButton = new JButton("Remove");
            add(removeButton, gbc);
        }

        public EmployeeHistory getHistory() {
            return history;
        }

        public void addActionListener(ActionListener listener) {
            removeButton.addActionListener(listener);
        }

        public void removeActionListener(ActionListener listener) {
            removeButton.removeActionListener(listener);
        }

    }

}