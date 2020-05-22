import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.AbstractTableModel;

public class TableDeleteRowsTest {

    public static void main(String[] args) {
        new TableDeleteRowsTest();
    }

    public TableDeleteRowsTest() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                final UserTableModel model = new UserTableModel(
                        new User("Kermit"),
                        new User("Fozzie"),
                        new User("Animal"),
                        new User("Miss Piggy"),
                        new User("Gonzo"),
                        new User("Beaker"),
                        new User("Crazy Harry"),
                        new User("Floyd Pepper"),
                        new User("Sweetums"));

                final JTable table = new JTable(model);

                JButton delete = new JButton("Delete");
                delete.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int[] selectedRows = table.getSelectedRows();
                        if (selectedRows.length > 0) {
                            List<User> users = new ArrayList<>(selectedRows.length);
                            for (int row : selectedRows) {
                                int modelRow = table.convertRowIndexToModel(row);
                                Boolean selected = (Boolean) model.getValueAt(modelRow, 1);
                                if (selected) {
                                    users.add(model.getUser(modelRow));
                                }
                            }
                            if (users.size() > 0) {
                                new DeleteUserWorker(users, model).execute();
                            }
                        }
                    }
                });

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new JScrollPane(table));
                frame.add(delete, BorderLayout.SOUTH);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class DeleteUserWorker extends SwingWorker<List<User>, User> {

        private List<User> users;
        private UserTableModel model;

        public DeleteUserWorker(List<User> users, UserTableModel model) {
            this.users = users;
            this.model = model;
        }

        @Override
        protected void process(List<User> chunks) {
            for (User user : users) {
                model.remove(user);
            }
        }

        @Override
        protected List<User> doInBackground() throws Exception {
            for (User user : users) {
                // Simulated delay
                Thread.sleep(250);
                publish(user);
            }
            return users;
        }

    }

    public class UserTableModel extends AbstractTableModel {

        private List<User> users;
        private List<Boolean> selected;

        public UserTableModel(User... users) {
            this.users = new ArrayList<>(Arrays.asList(users));
            selected = new ArrayList<>(this.users.size());
            for (User user : this.users) {
                selected.add(new Boolean(false));
            }
        }

        public User getUser(int row) {
            return users.get(row);
        }

        @Override
        public int getRowCount() {
            return users.size();
        }

        @Override
        public int getColumnCount() {
            return 2;
        }

        @Override
        public String getColumnName(int column) {
            String name = "?";
            switch (column) {
                case 0:
                    name = "User";
                    break;
                case 1:
                    name = "";
                    break;
            }
            return name;
        }

        @Override
        public Class getColumnClass(int column) {
            Class type = String.class;
            switch (column) {
                case 0:
                    type = String.class;
                    break;
                case 1:
                    type = Boolean.class;
                    break;
            }
            return type;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Object value = null;
            switch (columnIndex) {
                case 0:
                    value = users.get(rowIndex).getName();
                    break;
                case 1:
                    value = selected.get(rowIndex);
                    break;
            }
            return value;
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return columnIndex == 1;
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            switch (columnIndex) {
                case 1:
                    if (aValue instanceof Boolean) {
                        selected.set(rowIndex, (Boolean) aValue);
                        fireTableCellUpdated(rowIndex, columnIndex);
                    }
                    break;
            }
        }

        public void remove(User user) {
            int index = users.indexOf(user);
            if (index >= 0) {
                selected.remove(index);
                users.remove(user);
                fireTableRowsDeleted(index, index);
            }
        }
    }

    public class User {

        private String name;

        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}