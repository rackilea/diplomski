import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class Demo {

    private void initGUI(){

        DefaultTableModel dtm = new DefaultTableModel(new Object[]{"Property", "Value"}, 0);
        dtm.addRow(new Object[]{"Property 1", true});
        dtm.addRow(new Object[]{"Property 2", false});

        JTable table = new JTable(dtm){
            @Override
            public TableCellEditor getCellEditor(int row, int column) {
                if(getValueAt(row, column) instanceof Boolean){
                    return super.getDefaultEditor(Boolean.class);
                }
                return super.getCellEditor(row, column);
            }

            @Override
            public TableCellRenderer getCellRenderer(int row, int column) {
                if(getValueAt(row, column) instanceof Boolean){
                    JCheckBox cb = (JCheckBox) getDefaultRenderer(Boolean.class);
                    cb.setHorizontalAlignment(SwingConstants.LEFT);
                    return getDefaultRenderer(Boolean.class);
                }

                return super.getCellRenderer(row, column);
            }
        };

        JCheckBox cb = new JCheckBox();
        cb.setHorizontalAlignment(SwingConstants.LEFT);
        TableCellEditor tce = new DefaultCellEditor(cb);        
        table.setDefaultEditor(Boolean.class, tce);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(300,200));

        JPanel content = new JPanel(new BorderLayout());
        content.add(scrollPane);

        JFrame frame = new JFrame("Demo");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setContentPane(content);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);        
    }


    public static void main(String[] args) {        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Demo().initGUI();
            }
        });
    }

}