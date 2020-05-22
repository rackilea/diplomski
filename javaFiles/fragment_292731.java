import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class StrikeThroughRow {
   public static final Object[][] DATA = {{Boolean.TRUE, "Monday", "fe"},
      {Boolean.FALSE, "Tuesday", "fi"}, {Boolean.TRUE, "Wednesday", "fo"},
      {Boolean.FALSE, "Thursday", "fum"}, {Boolean.TRUE, "Friday", "foo"}};

   public StrikeThroughRow() {

   }

   private static void createAndShowUI() {
      JTable table = new JTable(new StrikeThroughModel(DATA));
      JScrollPane scrollpane = new JScrollPane(table);

      JFrame frame = new JFrame("StrikeThroughRow");
      frame.getContentPane().add(scrollpane);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            createAndShowUI();
         }
      });
   }
}

class StrikeThroughModel extends DefaultTableModel {
   public StrikeThroughModel(Object[][] data) {
      super(new String[]{"Check", "Work Day", "Giant Speak"}, 0);
      for (int i = 0; i < data.length; i++) {
         Vector<Object> rowVect = new Vector<Object>();
         rowVect.add(data[i][0]);
         if (data[i].length > 1) {
            for (int j = 1; j < data[i].length; j++) {
               rowVect.add(new TextWrapper(data[i][j].toString(), (Boolean)data[i][0]));
            }
         }
         addRow(rowVect);
      }
   }

   @Override
   public Class<?> getColumnClass(int columnIndex) {
      if (columnIndex == 0) {
         return Boolean.class;
      }
      return super.getColumnClass(columnIndex);
   }

   @Override
   public void setValueAt(Object value, int row, int column) {
      if (column == 0) {
         for (int i = 1; i < getColumnCount(); i++) {
            TextWrapper textWrapper = (TextWrapper) getValueAt(row, i);
            textWrapper.setStrikeThrough((Boolean) value);
            fireTableCellUpdated(row, i);
         }
      }
      super.setValueAt(value, row, column);
   }
}

class TextWrapper {
   private String text;
   private boolean strikeThrough = false;

   public TextWrapper(String text) {
      this.text = text;
   }

   public TextWrapper(String text, boolean strikeThrough) {
      this(text);
      this.strikeThrough = strikeThrough;
   }

   @Override
   public String toString() {
      if (strikeThrough) {
         return "<html><strike>" + text + "</html></strike>"; 
      }
      return text;
   }

   public void setStrikeThrough(boolean strikeThrough) {
      this.strikeThrough = strikeThrough;
   }
}