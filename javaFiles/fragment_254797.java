import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.UIManager.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class JTableRowHeader {

    private JFrame frame = new JFrame("JTable RowHeader");
    private JScrollPane scrollPane;
    private JTable table;
    private DefaultTableModel dataModel;
    private DefaultTableModel model;
    private TableRowSorter<TableModel> sorter;
    private JTable headerTable;
    private String[] columnNames = {"test1", "test2", "test3", "test3"};

    public JTableRowHeader() {
        table = new JTable(4, 4);
        dataModel = (DefaultTableModel) table.getModel();
        for (int i = 0; i < dataModel.getRowCount(); i++) {
            for (int ii = 0; ii < dataModel.getRowCount(); ii++) {
                dataModel.setValueAt(i + ii, i, ii);
            }
        }
        TableColumnModel tcm = table.getColumnModel();        
        tcm.getColumn(0).setHeaderValue(columnNames[0]);
        tcm.getColumn(1).setHeaderValue(columnNames[1]);
        tcm.getColumn(2).setHeaderValue(columnNames[2]);
        tcm.getColumn(3).setHeaderValue(columnNames[3]);
        sorter = new TableRowSorter<TableModel>(table.getModel());
        table.setRowSorter(sorter);
        model = new DefaultTableModel() {
            private static final long serialVersionUID = 1L;

            @Override
            public int getColumnCount() {
                return 1;
            }

            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }

            @Override
            public int getRowCount() {
                return table.getRowCount();
            }

            @Override
            public Class<?> getColumnClass(int colNum) {
                switch (colNum) {
                    case 0:
                        return String.class;
                    default:
                        return super.getColumnClass(colNum);
                }
            }
        };
        headerTable = new JTable(model);
        for (int i = 0; i < table.getRowCount(); i++) {
            headerTable.setValueAt("Row " + (i + 1), i, 0);
        }
        headerTable.setShowGrid(false);
        headerTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        headerTable.setPreferredScrollableViewportSize(new Dimension(50, 0));
        headerTable.getColumnModel().getColumn(0).setPreferredWidth(50);
        headerTable.getColumnModel().getColumn(0).setCellRenderer(new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable x, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

                boolean selected = table.getSelectionModel().isSelectedIndex(row);
                Component component = table.getTableHeader().getDefaultRenderer().getTableCellRendererComponent(table, value, false, false, -1, -2);
                ((JLabel) component).setHorizontalAlignment(SwingConstants.CENTER);
                if (selected) {
                    component.setFont(component.getFont().deriveFont(Font.BOLD));
                    component.setForeground(Color.red);
                } else {
                    component.setFont(component.getFont().deriveFont(Font.PLAIN));
                }
                return component;
            }
        });
        table.getRowSorter().addRowSorterListener(new RowSorterListener() {
            @Override
            public void sorterChanged(RowSorterEvent e) {
                model.fireTableDataChanged();
            }
        });
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                model.fireTableRowsUpdated(0, model.getRowCount() - 1);
            }
        });
        scrollPane = new JScrollPane(table);
        scrollPane.setRowHeaderView(headerTable);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(scrollPane);
        frame.add(new JButton(new AbstractAction("Toggle filter") {
            private static final long serialVersionUID = 1L;
            private RowFilter<TableModel, Object> filter = new RowFilter<TableModel, Object>() {
                @Override
                public boolean include(javax.swing.RowFilter.Entry<? extends TableModel, ? extends Object> entry) {
                    return ((Number) entry.getValue(0)).intValue() % 2 == 0;
                }
            };

            @Override
            public void actionPerformed(ActionEvent e) {
                if (sorter.getRowFilter() != null) {
                    sorter.setRowFilter(null);
                } else {
                    sorter.setRowFilter(filter);
                }
            }
        }), BorderLayout.SOUTH);
        frame.pack();
        frame.setLocation(150, 150);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        try {// UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if (info.getName().equals("Nimbus")) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JTableRowHeader TestTableRowHeader = new JTableRowHeader();
            }
        });
    }
}