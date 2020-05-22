import java.awt.*;
import java.util.Random;
import java.util.Vector;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

public class Forum implements ListSelectionListener {

    private JFrame frame = new JFrame("Frame");
    private JPanel fatherCenter = new JPanel();
    private JScrollPane tableScroll = new JScrollPane();
    private MyTableModel tableModel;
    private JTable dialogTable;
    private ListSelectionModel lsDialog;
    private Color clr;
    private Color clr1;

    private void addData() {
        Runnable doRun1 = new Runnable() {
            @Override
            public void run() {
                tableModel.resetTable();
                Vector<String> tbl = new Vector<String>();
                Vector<Object> tbl1 = new Vector<Object>();
                Random rnd = new Random();
                tbl.add("Integer");
                tbl.add("Double");
                tbl.add("Boolean");
                tbl.add("Boolean");
                tbl.add("String");
                tableModel.setColumnNames(tbl);
                for (int row = 0; row < 30; row++) {
                    tbl1 = null;
                    tbl1 = new Vector<Object>();
                    tbl1.addElement(row + 1);
                    tbl1.addElement(rnd.nextInt(25) + 3.14);
                    tbl1.addElement((row % 3 == 0) ? false : true);
                    tbl1.addElement((row % 5 == 0) ? false : true);
                    if (row % 7 == 0) {
                        tbl1.add(("Canc"));
                    } else if (row % 6 == 0) {
                        tbl1.add(("Del"));
                    } else {
                        tbl1.add(("New"));
                    }
                    tableModel.addRow(tbl1);
                }
                addTableListener();
            }
        };
        SwingUtilities.invokeLater(doRun1);
    }

    private void addTableListener() {
        tableModel.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent tme) {
                if (tme.getType() == TableModelEvent.UPDATE) {
                    System.out.println("");
                    System.out.println("Cell " + tme.getFirstRow() + ", "
                            + tme.getColumn() + " changed. The new value: "
                            + tableModel.getValueAt(tme.getFirstRow(),
                            tme.getColumn()));
                }
            }
        });
    }

    @Override
    public void valueChanged(ListSelectionEvent le) {
        int row = dialogTable.getSelectedRow();
        int col = dialogTable.getSelectedColumn();
        String str = "Selected Row(s): ";
        int[] rows = dialogTable.getSelectedRows();
        for (int i = 0; i < rows.length; i++) {
            str += rows[i] + " ";
        }
        str += "Selected Column(s): ";
        int[] cols = dialogTable.getSelectedColumns();
        for (int i = 0; i < cols.length; i++) {
            str += cols[i] + " ";
        }
        str += "Selected Cell: " + dialogTable.getSelectedRow() + ", " + dialogTable.getSelectedColumn();
        System.out.println(str);
        Object value = dialogTable.getValueAt(row, col);
        System.out.println(String.valueOf(value));
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Forum osFrame = new Forum();
            }
        });
    }

    public Forum() {
        tableModel = new MyTableModel();
        dialogTable = new JTable(tableModel) {
            private static final long serialVersionUID = 1L;

            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component comp = super.prepareRenderer(renderer, row, column);
                JComponent jc = (JComponent) comp;//for Custom JComponent
                if (!isRowSelected(row)) {
                    int modelRow = convertRowIndexToModel(row);
                    boolean type = (Boolean) getModel().getValueAt(modelRow, 2);
                    boolean type1 = (Boolean) getModel().getValueAt(modelRow, 3);
                    comp.setForeground(Color.black);
                    if ((type) && (!type1)) {
                        comp.setBackground(clr1);
                    } else if ((!type) && (type1)) {
                        comp.setBackground(Color.orange);
                    } else if ((!type) || (!type1)) {
                        comp.setBackground(Color.red);
                    } else {
                        comp.setBackground(row % 2 == 0 ? getBackground() : getBackground().darker());
                    }
                    dialogTable.convertRowIndexToView(0);
                } else {
                    comp.setForeground(Color.blue);
                }
                if (!isCellEditable(row, column)) {
                    comp.setForeground(Color.red);
                    comp.setBackground(Color.magenta);
                }
                return comp;
            }
        };
        tableScroll = new JScrollPane(dialogTable, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        tableScroll.setBorder(null);
        dialogTable.getTableHeader().setReorderingAllowed(false);
        dialogTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lsDialog = dialogTable.getSelectionModel();
        dialogTable.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
        dialogTable.setRowHeight(20);
        dialogTable.setRowMargin(2);
        dialogTable.setPreferredScrollableViewportSize(dialogTable.getPreferredSize());
        ListSelectionModel rowSelMod = dialogTable.getSelectionModel();
        //ListSelectionModel colSelMod = dialogTable.getColumnModel().getSelectionModel();
        rowSelMod.addListSelectionListener(this);
        //colSelMod.addListSelectionListener(this);        
        fatherCenter = new JPanel();
        fatherCenter.setLayout(new BorderLayout(10, 10));
        fatherCenter.add(tableScroll, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));
        frame.add(fatherCenter);
        frame.setPreferredSize(new Dimension(400, 660));
        frame.pack();
        frame.setLocation(150, 150);
        frame.setVisible(true);
        addData();
    }

    private class MyTableModel extends AbstractTableModel {

        private static final long serialVersionUID = 1L;
        private Vector<Vector<Object>> _data;
        private Vector<String> _colNames;
        private boolean[] _columnsVisible = {true, true, true, true, true};

        public MyTableModel() {
            _colNames = new Vector<String>();
            _data = new Vector<Vector<Object>>();
        }

        public MyTableModel(Vector<String> colnames) {
            _colNames = colnames;
            _data = new Vector<Vector<Object>>();
        }

        public void resetTable() {
            _colNames.removeAllElements();
            _data.removeAllElements();
        }

        public void setColumnNames(Vector<String> colNames) {
            _colNames = colNames;
            fireTableStructureChanged();
        }

        public void addRow(Vector<Object> data) {
            _data.add(data);
            fireTableRowsInserted(_data.size() - 1, _data.size() - 1);
        }

        public void removeRowAt(int row) {
            _data.removeElementAt(row);
            fireTableRowsDeleted(row - 1, _data.size() - 1);
        }

        @Override
        public int getColumnCount() {
            return _colNames.size();
        }

        @Override
        public Class<?> getColumnClass(int colNum) {
            switch (colNum) {
                case 0:
                    return Integer.class;
                case 1:
                    return Double.class;
                case 2:
                    return Boolean.class;
                case 3:
                    return Boolean.class;
                default:
                    return String.class;
            }
        }

        @Override
        public boolean isCellEditable(int row, int colNum) {
            switch (colNum) {
                case 2:
                    return false;
                default:
                    return true;
            }
        }

        @Override
        public String getColumnName(int colNum) {
            return _colNames.get(colNum);
        }

        @Override
        public int getRowCount() {
            return _data.size();
        }

        @Override
        public Object getValueAt(int row, int col) {
            Vector<Object> value = _data.get(row);
            return value.get(col);
        }

        @Override
        public void setValueAt(Object newVal, int row, int col) {
            Vector<Object> aRow = _data.elementAt(row);
            aRow.remove(col);
            aRow.insertElementAt(newVal, col);
            fireTableCellUpdated(row, col);
        }

        public void setColumnVisible(int index, boolean visible) {
            _columnsVisible[index] = visible;
            fireTableStructureChanged();
        }
    }
}