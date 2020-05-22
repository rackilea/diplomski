import java.awt.BorderLayout;
import java.util.Vector;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class TestTableSortFilter {

    private JTable jTable = new JTable(createTableModel());
    private JLabel rowCountLabel = new JLabel();

    private TableRowSorter<TableModel> rowSorter
            = new TableRowSorter<>(jTable.getModel());

    private JTextField jtfFilter = new JTextField();
    private JButton jbtFilter = new JButton("Filter");

    public TestTableSortFilter() {
        jTable.setRowSorter(rowSorter);
        addListenerToSorter(rowSorter, jTable, rowCountLabel);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("Specify a number to match:"),
                BorderLayout.LINE_START);
        panel.add(jtfFilter, BorderLayout.CENTER);
        panel.add(rowCountLabel, BorderLayout.PAGE_END);

        rowCountLabel.setText("Number of view rows: " + jTable.getRowCount());

        jtfFilter.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) { sortRows(); }
            @Override
            public void removeUpdate(DocumentEvent e) { sortRows(); }
            @Override
            public void changedUpdate(DocumentEvent e) {}

            private void sortRows() {
                String text = jtfFilter.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            } 
        });

        JFrame frame = new JFrame();
        frame.add(panel, BorderLayout.PAGE_END);
        frame.add(new JScrollPane(jTable), BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    private TableModel createTableModel() {
        String[] cols = {"col1", "col2", "col3", "col4"};
        DefaultTableModel model = new DefaultTableModel(cols, 0);
        int value = 0;
        for (int i = 0; i < 100; i++) {
            Vector row = new Vector();
            for (int j = 0; j < cols.length; j++) {
                row.add(value);
                value++;
            }
            model.addRow(row);
        }
        return model;
    }

    private void addListenerToSorter(RowSorter rowSorter, 
                               final JTable table, 
                               final JLabel rowCountLabel) {

        rowSorter.addRowSorterListener(new RowSorterListener() {
            @Override
            public void sorterChanged(RowSorterEvent e) {
                int newRowCount = table.getRowCount();
                rowCountLabel.setText("Number of view rows: " + newRowCount);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                new TestTableSortFilter();
            }
        });
    }
}