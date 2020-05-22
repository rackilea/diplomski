import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import javax.swing.event.*;
import javax.swing.table.*;
import javax.swing.*;

public class JTableDelete extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private JTextField textField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JTableDelete frame = new JTableDelete();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public JTableDelete() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        table = new JTable();
        table.setModel(new DefaultTableModel(new Object[][] { { "Red" }, { "Green" }, { "Blue" }, { "Violet" }, { "Orange" }, },
                new String[] { "Colors" }));

        ListSelectionModel cellSelectionModel = table.getSelectionModel();
        cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                int selectedRow = table.getSelectedRow();
                int selectedColumn = table.getSelectedColumn();
                if (selectedRow != -1 && selectedColumn != -1)
                    textField.setText((String) table.getValueAt(selectedRow, selectedColumn));
                else
                    textField.setText("");
            }

        });

        contentPane.add(table, BorderLayout.CENTER);

        JButton btnDelete = new JButton("Delete");
        btnDelete.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                int rowCount = table.getRowCount() - 1; // -1 because counting starts at 0
                if (row != -1) {
                    ((DefaultTableModel) table.getModel()).removeRow(row);
                    rowCount--; // 1 less row now
                    if (row < table.getRowCount()) // next selection
                        table.setRowSelectionInterval(row, row);
                    else if (rowCount != -1) // end selection
                        table.setRowSelectionInterval(rowCount, rowCount);
                }
            }
        });
        contentPane.add(btnDelete, BorderLayout.SOUTH);

        textField = new JTextField();
        textField.setEnabled(false);
        contentPane.add(textField, BorderLayout.NORTH);
        textField.setColumns(10);

        pack();
    }

}