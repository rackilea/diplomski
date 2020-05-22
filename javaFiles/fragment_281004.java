import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AddRowB extends JPanel {
    private MyTableModel tableModel = new MyTableModel();
    private JTable table = new JTable(tableModel);

    public AddRowB() {
        JPanel addPanel = new JPanel();
        addPanel.add(new JButton(new AddAction("Add")));

        setLayout(new BorderLayout());
        add(new JScrollPane(table));
        add(addPanel, BorderLayout.PAGE_END);
    }

    private class AddAction extends AbstractAction {
        public AddAction(String name) {
            super(name);
            int mnemonic = (int) name.charAt(0);
            putValue(MNEMONIC_KEY, mnemonic);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            RowData row = new RowData("Type", "Address", "User ID");
            tableModel.addRow(row);
        }
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("Add Row B");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new AddRowB());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}

class MyTableModel extends DefaultTableModel {
    private static final String[] COLUMNS = {"Type", "Address", "User ID"};

    public MyTableModel() {
        super(COLUMNS, 0);
    }

    public void addRow(RowData rowData) {
        Object[] row = {
                rowData.getType(),
                rowData.getAddress(),
                rowData.getUserID()
        };
        addRow(row);
    }
}

class RowData {
    String type;
    String address;
    String userID;

    public RowData(String type, String address, String userID) {
        this.type = type;
        this.address = address;
        this.userID = userID;
    }

    public String getType() {
        return type;
    }

    public String getAddress() {
        return address;
    }

    public String getUserID() {
        return userID;
    }

}