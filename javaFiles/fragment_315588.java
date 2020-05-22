import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

@SuppressWarnings("serial")
public class DisplaySelectedTableCells extends JPanel {
   public static final Integer[][] DATA = {
      {1, 2, 3}, {4, 5, 6}, {7, 8, 9},
      {1, 2, 3}, {4, 5, 6}, {7, 8, 9},
      {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
   };
   public static final String[] COLS = {"A", "B", "C"};
   private static final int PREF_WIDTH = 400;
   private static final int PREF_HEIGHT = 300;
   private DefaultTableModel model = new DefaultTableModel(DATA, COLS) {
      @Override
      public Class<?> getColumnClass(int columnIndex) {
         return Integer.class;
      }
   };
   private JTable table = new JTable(model);
   private JToggleButton toggleBtn = new JToggleButton("Show Selected Rows");
   private MyCellRenderer myCellRenderer = new MyCellRenderer();

   public DisplaySelectedTableCells() {
      table.setDefaultRenderer(Integer.class, myCellRenderer);
      JPanel btnPanel = new JPanel();
      btnPanel.add(toggleBtn);

      setLayout(new BorderLayout());
      add(new JScrollPane(table), BorderLayout.CENTER);
      add(btnPanel, BorderLayout.SOUTH);

      toggleBtn.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            myCellRenderer.setShowSelected(toggleBtn.isSelected());
            table.repaint();
         }
      });
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_WIDTH, PREF_HEIGHT);
   }

   private static class MyCellRenderer extends DefaultTableCellRenderer {
      private static final Color SELECTED_COLOR = Color.pink;
      private static final Color UNSELECTED_COLOR = Color.lightGray;
      private static final Color BASE_COLOR = null;
      private boolean showSelected = false;

      public void setShowSelected(boolean showSelected) {
         this.showSelected = showSelected;
      }

      @Override
      public Component getTableCellRendererComponent(JTable table,
               Object value, boolean isSelected, boolean hasFocus, int row,
               int column) {
         Component superComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus,
                  row, column);

         if (showSelected) {
            if (isSelected) {
               superComponent.setBackground(SELECTED_COLOR);
            } else {
               superComponent.setBackground(UNSELECTED_COLOR);
            }
         } else {
            superComponent.setBackground(BASE_COLOR);
         }

         return superComponent;
      }
   }

   private static void createAndShowUI() {
      JFrame frame = new JFrame("DisplaySelectedTableCells");
      frame.getContentPane().add(new DisplaySelectedTableCells());
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