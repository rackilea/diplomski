import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private myTableModel tableModel;
    private JTable dialogTable;
    private JButton blueButton;
    private ListSelectionModel lsDialog;
    private Color clr;
    private Color clr1;

    private void addComponentsToPane(Container pane) {
        tableModel = new myTableModel();
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
        ListSelectionModel rowSelMod = dialogTable.getSelectionModel();
        //ListSelectionModel colSelMod = dialogTable.getColumnModel().getSelectionModel();
        rowSelMod.addListSelectionListener(this);
        //colSelMod.addListSelectionListener(this);
        blueButton = new JButton(" Blue BackGround ");
        blueButton.setPreferredSize(new Dimension(100, 30));
        blueButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (clr == Color.white) {
                    clr = Color.orange;
                    clr1 = Color.yellow;
                } else {
                    clr = Color.white;
                    clr1 = Color.black;
                }
                System.out.println(clr);
                dialogTable.setBackground(clr);
                dialogTable.repaint();
            }
        });
        fatherCenter = new JPanel();
        fatherCenter.setLayout(new BorderLayout(10, 10));
        fatherCenter.add(tableScroll, BorderLayout.CENTER);
        fatherCenter.add(blueButton, BorderLayout.SOUTH);
        pane.add(fatherCenter);
    }

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

    private void createAndShowGUI() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));
        addComponentsToPane(frame.getContentPane());
        addData();
        frame.setLocation(150, 150);
        frame.setPreferredSize(new Dimension(400, 647));
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Forum osFrame = new Forum();
    }

    public Forum() {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private class myTableModel extends AbstractTableModel {

        private static final long serialVersionUID = 1L;
        private Vector<Vector<Object>> data;
        private Vector<String> colNames;
        private boolean[] _columnsVisible = {true, true, true, true, true};

        myTableModel() {
            this.colNames = new Vector<String>();
            this.data = new Vector<Vector<Object>>();
        }

        myTableModel(Vector<String> colnames) {
            this.colNames = colnames;
            this.data = new Vector<Vector<Object>>();
        }

        public void resetTable() {
            this.colNames.removeAllElements();
            this.data.removeAllElements();
        }

        public void setColumnNames(Vector<String> colNames) {
            this.colNames = colNames;
            this.fireTableStructureChanged();
        }

        public void addRow(Vector<Object> data) {
            this.data.add(data);
            //this.fireTableDataChanged();
            //this.fireTableStructureChanged();
            this.fireTableRowsInserted(data.size() - 1, data.size() - 1);
        }

        public void removeRowAt(int row) {
            this.data.removeElementAt(row);
            //this.fireTableDataChanged();
            this.fireTableRowsDeleted(row - 1, data.size() - 1);
        }

        @Override
        public int getColumnCount() {
            return this.colNames.size();
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
            return this.colNames.get(colNum);
        }

        @Override
        public int getRowCount() {
            return this.data.size();
        }

        @Override
        public Object getValueAt(int row, int col) {
            Vector<Object> value = this.data.get(row);
            return value.get(col);
        }

        @Override
        public void setValueAt(Object newVal, int row, int col) {
            Vector<Object> aRow = data.elementAt(row);
            aRow.remove(col);
            aRow.insertElementAt(newVal, col);
            fireTableCellUpdated(row, col);
        }

        public void setColumnVisible(int index, boolean visible) {
            this._columnsVisible[index] = visible;
            this.fireTableStructureChanged();
        }
    }
}