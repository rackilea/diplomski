import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.event.*;
import javax.swing.table.*;

public class ExpenditurePanel extends JPanel implements TableModelListener {

   private static final long serialVersionUID = 1L;
   private static TableModel1 model;
   private JTable table;

   public ExpenditurePanel() {
      model = new TableModel1();
      table = new JTable(model);
      table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null,
            null));
      table.setRowSelectionAllowed(false);
      table.setFillsViewportHeight(true);
      table.setCellSelectionEnabled(true);
      table.setColumnSelectionAllowed(false);

      model.addColumn("Name");
      model.addColumn("Week");
      model.addColumn("Fortnight");
      model.addColumn("Month");
      model.addColumn("Year");
      model.addColumn("Remove");

      Object[] default1 = { "Accomodation", "", "", "", "", false };
      Object[] default2 = { "Food", "", "", "", "", false };

      model.addRow(default1);
      model.addRow(default2);

      model.addTableModelListener(this);

      this.add(new JScrollPane(table));
      table.setRowSorter(null);

   }

   public static TableModel1 getModel() {
      return model;
   }

   @Override
   public void tableChanged(TableModelEvent e) {
      int row = e.getFirstRow();
      int column = e.getColumn();

      // **** printf added below
      System.out.printf("[row: %d, column: %d]%n", row, column);

      model = (TableModel1) e.getSource();

      String columnName = model.getColumnName(column);

      // **** println added below
      System.out.println("columnName: " + columnName);

      Object data = model.getValueAt(row, column);

      if (model.getValueAt(row, column) == Boolean.TRUE) {
         System.out.println("Condition working");

         // *** AIOOBE called here
         model.removeRow(row);
      }
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            ExpenditurePanel panel = new ExpenditurePanel();
            JFrame frame = new JFrame("foo");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(panel);
            frame.setLocationRelativeTo(null);
            frame.pack();
            frame.setVisible(true);
         }
      });
   }
}

// **** no idea how close this is to your code *****
class TableModel1 extends DefaultTableModel {
   @Override
   public Class<?> getColumnClass(int columnIndex) {
      if (getRowCount() == 0) {
         return super.getColumnClass(columnIndex);
      }
      Object value = getValueAt(0, columnIndex);
      if (value == null) {
         return super.getColumnClass(columnIndex);
      }

      return value.getClass();
   }
}