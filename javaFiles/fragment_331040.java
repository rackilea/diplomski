import java.awt.Component;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class test extends JFrame {
    public static DefaultTableModel model = new DefaultTableModel(0, 4) {
      public Class getColumnClass(int columnIndex) {
        if (columnIndex == 2 || columnIndex == 3) {
          return Boolean.class;
        } else {
          return Object.class;
        }
      }
    };
    public static void main (String args[]){
      JTable table = new JTable();
      table.setDefaultRenderer(Boolean.class, new CheckboxTableCellRenderer());
      model.addRow(new Object[] {"testData2","testData1",false,true});
      table.setModel(model);
      JFrame frame = new JFrame();
      frame.add(new JScrollPane(table));
      frame.setSize(640,480);
      frame.setVisible(true);
    }

    public static class CheckboxTableCellRenderer<E> extends JCheckBox implements
     TableCellRenderer {

      @Override
      public Component getTableCellRendererComponent( JTable table,
              Object value, boolean isSelected, boolean hasFocus,
              int row, int column ){
           setComponentOrientation(table.getComponentOrientation());

           setFont(table.getFont());

            if (!isSelected) {
              setBackground(table.getBackground());
              setForeground(table.getForeground());
            } else {
              setBackground(table.getSelectionBackground());
              setForeground(table.getSelectionForeground());
            }


           setSelected((Boolean) value);
           setEnabled(table.isEnabled());

           return this;
      }

    }

}