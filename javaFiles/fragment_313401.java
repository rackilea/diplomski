import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class ScrollPaneRefresh extends JPanel {
   private static final int PREF_W = 600;
   private static final int PREF_H = 200;
   private Integer[][] initialData = {
         {1, 2}, {3, 4}, {5, 6}, {7, 8}, {9, 0},
         {1, 2}, {3, 4}, {5, 6}, {7, 8}, {9, 0},
         {1, 2}, {3, 4}, {5, 6}, {7, 8}, {9, 0}
         };
   private Integer[][] newData = {
         {1, 2}, {3, 4}
         };
   private String[] columnNames = {"Col1", "Col2"};
   private TablePanel gregsPanel = new TablePanel("With fireTableDataChanged", initialData, columnNames);
   private TablePanel myPanel = new TablePanel("Without fireTableDataChanged", initialData, columnNames);

   public ScrollPaneRefresh() {
      gregsPanel.setButtonAction(new AbstractAction("Change Table Data") {
         private boolean changeToNewData = true;

         @Override
         public void actionPerformed(ActionEvent evt) {
            if (changeToNewData) {
               gregsPanel.setTableModelDataVector(newData, columnNames);
            } else {
               gregsPanel.setTableModelDataVector(initialData, columnNames);
            }
            gregsPanel.fireTableDataChanged();
            changeToNewData = !changeToNewData;
         }
      });
      myPanel.setButtonAction(new AbstractAction("Change Table Data") {
         private boolean changeToNewData = true;

         @Override
         public void actionPerformed(ActionEvent evt) {
            if (changeToNewData) {
               myPanel.setTableModelDataVector(newData, columnNames);
            } else {
               myPanel.setTableModelDataVector(initialData, columnNames);
            }
            // myPanel.getScrollPane().getViewport().revalidate();
            changeToNewData = !changeToNewData;
         }
      });

      setLayout(new GridLayout(1, 0));
      add(gregsPanel.getMainPanel());
      add(myPanel.getMainPanel());
   }

   @Override // so scrollbars will show
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   private static void createAndShowGui() {
      ScrollPaneRefresh mainPanel = new ScrollPaneRefresh();

      JFrame frame = new JFrame("ScrollPaneRefresh");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}

class TablePanel {
   private JPanel mainPanel = new JPanel();
   private DefaultTableModel dm;
   private JTable table = new JTable();
   private JButton changeTableBtn = new JButton();
   private JScrollPane scrollpane = new JScrollPane(table);

   public TablePanel(String title, Object[][] data, Object[] columnNames) {
      dm = new DefaultTableModel(data, columnNames);
      table.setModel(dm);
      JPanel btnPanel = new JPanel();
      btnPanel.add(changeTableBtn);

      mainPanel.setBorder(BorderFactory.createTitledBorder(title));
      mainPanel.setLayout(new BorderLayout(5, 5));
      mainPanel.add(scrollpane, BorderLayout.CENTER);
      mainPanel.add(btnPanel, BorderLayout.PAGE_END);
   }

   public void setButtonAction(Action action) {
      changeTableBtn.setAction(action);
   }

   public void setTableModelDataVector(Object[][] data, Object[] columnNames) {
      dm.setDataVector(data, columnNames);
   }

   public void fireTableDataChanged() {
      dm.fireTableDataChanged();
   }

   public JScrollPane getScrollPane() {
      return scrollpane;
   }

   public JComponent getMainPanel() {
      return mainPanel;
   }
}