import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.text.JTextComponent;

public class Main {

    public static void main(String[] args) {
        new Main().start();
    }

    private void start() {
        JFrame f = new JFrame();
        f.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        initTable();

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
        }

        JPanel calendar = new JPanel();
        calendar.setLayout(new GridBagLayout());
        calendar.setBorder(BorderFactory.createTitledBorder("Calendar"));
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 0;
        gbc.weightx = 0;
        calendar.add(scrollPane, gbc);
        f.add(calendar, gbc);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }
    JTable table;
    JScrollPane scrollPane;
    CalendarTableModel tableModel;

    private void initTable() {
        setTable(new JTable());
        getTable().setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        getTable().setAutoscrolls(false);
        getTable().getTableHeader().setResizingAllowed(false);
        getTable().getTableHeader().setReorderingAllowed(false);
        getTable().setColumnSelectionAllowed(true);
        getTable().setRowSelectionAllowed(true);
        getTable().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        tableModel = new CalendarTableModel();  //my class extended from AbstractTableModel
        getTable().setModel(tableModel);
        scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setAutoscrolls(false);

        TableColumnModel columnModel = table.getColumnModel();
        for (int col = 0; col < table.getColumnCount(); col++) {
            int maxWidth = 0;
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer rend = table.getCellRenderer(row, col);
                Object value = table.getValueAt(row, col);
                Component comp = rend.getTableCellRendererComponent(table, value, false, false, row, col);
                maxWidth = Math.max(comp.getPreferredSize().width, maxWidth);
            }
            TableColumn column = columnModel.getColumn(col);
            TableCellRenderer headerRenderer = column.getHeaderRenderer();
            if (headerRenderer == null) {
                headerRenderer = table.getTableHeader().getDefaultRenderer();
            }
            Object headerValue = column.getHeaderValue();
            Component headerComp = headerRenderer.getTableCellRendererComponent(table, headerValue, false, false, 0, col);
            maxWidth = Math.max(maxWidth, headerComp.getPreferredSize().width);
            // note some extra padding
            column.setPreferredWidth(maxWidth + 6);//IntercellSpacing * 2 + 2 * 2 pixel instead of taking this value from Borders
        }
        DefaultTableCellRenderer stringRenderer = (DefaultTableCellRenderer) table.getDefaultRenderer(String.class);
        stringRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
    }

    private void setTable(JTable jTable) {
        this.table = jTable;
    }

    private JTable getTable() {
        return this.table;
    }

    private class CalendarTableModel extends AbstractTableModel {

        private String[] daysData = {"Pondelok", "Út", "St", "Čt", "Pá", "Sobota", "Ne"};
        private int[][] values;

        public CalendarTableModel() {
            values = new int[7][6];
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 7; j++) {
                    values[j][i] = 30;
                }
            }
        }

        @Override
        public int getRowCount() {
            return 6;
        }

        @Override
        public int getColumnCount() {
            return 7;
        }

        @Override
        public String getColumnName(int column) {
            return daysData[column];
        }

        @Override
        public Object getValueAt(int row, int column) {
            return this.values[column][row];
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    }
}