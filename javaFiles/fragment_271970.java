import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;


public class PrepareRendereEx {

public static void main(String[] args) {

    JFrame frame = new JFrame();
    frame.setSize(new Dimension(400, 100));

    Object data[][] = { {"java", "j2ee"}, 
                        {"java", "j2ee"}, 
                        {"java", "j2ee"}
                      };
    Object[] columnNames = {"Java", "J2EE"};

    DefaultTableModel model = new DefaultTableModel(data, columnNames);
    JTable table = new JTable(model) {
        @Override
        public Component prepareRenderer(TableCellRenderer renderer, int rowIndex,
                int columnIndex) {
            JComponent component = (JComponent) super.prepareRenderer(renderer, rowIndex, columnIndex);  

            if(getValueAt(rowIndex, 0).toString().equalsIgnoreCase("java") && columnIndex == 0) {
                component.setBackground(Color.RED);
            } else if(getValueAt(rowIndex, 1).toString().equalsIgnoreCase("j2ee") && columnIndex == 1){
                component.setBackground(Color.GREEN);
            }

            return component;
        }
    };

    frame.add(new JScrollPane(table));
    frame.setVisible(true);
}
}