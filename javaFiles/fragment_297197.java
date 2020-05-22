import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.*;
import java.awt.Color;
import javax.swing.JLabel;

class ver_his_sign extends JFrame {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ver_his_sign();
            }
        });
    }

    ver_his_sign() {

        DefaultTableModel model = new DefaultTableModel(get_data(), get_header()) {
            @Override
            public boolean isCellEditable(int row, int col) {
                switch (col) {
                    case 0:
                        return false;
                    case 1:
                        return false;
                    case 2:
                        return true;
                    default:
                        return false;
                }
            }

            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    case 2:
                        return Boolean.class;
                    default:
                        return Boolean.class;
                }
            }
        };
        DefaultTableCellRenderer r = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object
                value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(
                    table, value, isSelected, hasFocus, row, column);
                setForeground(Color.blue);
                setHorizontalAlignment(JLabel.CENTER);
                setFont(getFont().deriveFont(50f));
                return this;
            }
        };
        JTable table = new JTable(model);
        table.setRowHeight(table.getRowHeight() + 50);
        table.getColumnModel().getColumn(1).setCellRenderer(r);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(new JScrollPane(table));
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    Object[][] get_data() {
        Object data[][] = new Object[][]{
            {"Uno, 1", "\u4e00", true},
            {"Uno, 1", "\u4e01", true},
            {"Uno, 1", "\u4e02", true},
            {"Uno, 1", "\u4e03", true},
            {"Uno, 1", "\u4e04", true}
        };
        return data;
    }

    String[] get_header() {
        String header[] = new String[]{"SIGNIFICADO", "KANJI", "Agregar"};
        return header;
    }
}