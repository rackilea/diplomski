import java.awt.Color;
import java.awt.Component;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class TestTableRenderer {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                NikeSaysJustDoIt();
            }
        });
    }

    private static void NikeSaysJustDoIt() {
        Random random = new Random();
        Object[][] data = new Object[30][7];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++)  {
                data[i][j] = (random.nextInt(65536) - 32768);
            }   
        }
        String[] cols = new String[] { "col", "col", "col", "col", "col", "col", "col" };
        DefaultTableModel model = new DefaultTableModel(data, cols);
        JTable table = new JTable(model) {
            @Override
            public Component prepareRenderer(TableCellRenderer renderer,
                    int row, int col) {

                Component c = super.prepareRenderer(renderer, row, col);
                if (col == 5 || col == 6) {
                    Integer intValue = (Integer) getValueAt(row, col);
                    c.setForeground(getColor(intValue));
                } else {
                    c.setForeground(getForeground());
                }
                return c;
            }

            private Color getColor(int intValue) {
                Color color = null;
                if (intValue > 0) {
                    color = Color.GREEN;
                } else if (intValue < 0) {
                    color = Color.RED;
                } else {
                    color = getForeground();
                }
                return color;
            }
        };
        JOptionPane.showMessageDialog(null, new JScrollPane(table));
    }
}