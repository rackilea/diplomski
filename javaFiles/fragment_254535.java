import java.awt.*;
import java.util.Random;

import javax.swing.*;
import javax.swing.table.*;

public class Board extends JPanel {

   private static final long serialVersionUID = 1L;

   int boardHeight = 20;
   int boardWidth = 10;

   JTable table;
   Random random = new Random();

   public Board() {
      setLayout(new BorderLayout()); // !!
      DefaultTableModel model = new DefaultTableModel(boardHeight, boardWidth) {
         @Override
         public Class<?> getColumnClass(int columnIndex) {
            return String.class;
         }
      };
      // !! table = new JTable(this.boardHeight, this.boardWidth);
      table = new JTable(model);
      for (int row = 0; row < model.getRowCount(); row++) {
         for (int col = 0; col < model.getColumnCount(); col++) {
            String s = random.nextBoolean() ? "red" : "yellow";
            model.setValueAt(s, row, col);
         }
      }
      table.setDefaultRenderer(String.class, new BoardTableCellRenderer());

      table.setFocusable(false);
      table.setShowGrid(false);
      table.setRowMargin(0);
      table.setIntercellSpacing(new Dimension(0, 0));
      table.setRowSelectionAllowed(false);
      table.setVisible(true);
      this.add(table);
      this.setPreferredSize(new Dimension(table.getPreferredSize().width,
               (table.getPreferredSize().height + 85)));
   }

   private static void createAndShowUI() {
      JFrame frame = new JFrame("Board");
      frame.getContentPane().add(new Board());
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

class BoardTableCellRenderer extends DefaultTableCellRenderer {

   private static final long serialVersionUID = 1L;

   public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int col) {

      Component c = super.getTableCellRendererComponent(table, value,
               isSelected, hasFocus, row, col);
      Object valueAt = table.getModel().getValueAt(row, col);
      String s = "";
      if (valueAt != null) {
         s = valueAt.toString();
      }

      if (s.equalsIgnoreCase("yellow")) {
         c.setForeground(Color.YELLOW);
         c.setBackground(Color.gray);
      } else {
         c.setForeground(Color.black);
         c.setBackground(Color.WHITE);
      }

      return c;
   }
}