import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class ScratchSpace {


    public static void main(final String[] args) {

        final JTable jTable = new JTable();

        jTable.setModel(new DefaultTableModel() {
            private static final long serialVersionUID = 1L;

            @Override
            public Object getValueAt(final int row, final int column) {
                final StringBuffer sb = new StringBuffer();
                sb.append("<html>");
                sb.append("<font color=\"red\">this text is red</font> ");
                sb.append("<font color=\"green\">this text is green!</font>");
                sb.append("</html>");
                return sb.toString();
            }

            @Override
            public int getColumnCount() {
                return 2;
            }

            @Override
            public int getRowCount() {
                return 2;
            }
        });


        jTable.getColumnModel().getColumn(0).setCellRenderer(new MyTableCellRenderer());
        jTable.getColumnModel().getColumn(1).setCellRenderer(new MyTableCellRenderer());
        final JFrame jFrame = new JFrame();
        jFrame.getContentPane().add(jTable);
        jFrame.setSize(120, 80);
        jFrame.pack();
        jFrame.setTitle("Table test");
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);

    }

    private static class MyTableCellRenderer extends JLabel implements TableCellRenderer {

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText(String.valueOf(value));
            table.setRowHeight(row, getPreferredSize().height);
            return this;
        }
    }
}