import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.DefaultCellEditor;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class ChangeFontInEditorDemo {
    private static final int IMPACT_COL = 0;
    private static final int ARIAL_COL = 1;
    private static final Font IMPACT_FONT = new Font("impact", Font.PLAIN, 20);
    private static final Font ARIAL_BOLD_FONT = new Font("arial", Font.BOLD, 20);

    public ChangeFontInEditorDemo() {
        JFrame frame = new JFrame();
        frame.add(new JScrollPane(getTable()));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JTable getTable() {
        String[][] data = { { "Data", "Data" }, { "Data", "Data" } };
        String[] cols = { "Col", "Col" };
        JTable table = new JTable(data, cols) {
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int col) {
                Component c = super.prepareRenderer(renderer, row, col);
                if (col == IMPACT_COL) {
                    c.setFont(IMPACT_FONT);
                } else if (col == ARIAL_COL) {
                    c.setFont(ARIAL_BOLD_FONT);
                }
                return c;
            }
            @Override
            public Dimension getPreferredScrollableViewportSize() {
                return new Dimension(300, 125);
            }
        };
        table.setRowHeight(20);

        JTextField impactField = getFontEditorField(IMPACT_FONT);
        TableColumn impactColumn = table.getColumnModel().getColumn(IMPACT_COL);
        impactColumn.setCellEditor(new DefaultCellEditor(impactField));

        JTextField arialBoldField = getFontEditorField(ARIAL_BOLD_FONT);
        TableColumn arialColumn = table.getColumnModel().getColumn(ARIAL_COL);
        arialColumn.setCellEditor(new DefaultCellEditor(arialBoldField));

        return table;
    }

    public JTextField getFontEditorField(Font font) {
        JTextField field = new JTextField();
        field.setFont(font);
        return field;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ChangeFontInEditorDemo();
            }
        });
    }
}