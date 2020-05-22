import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.*;
import javax.swing.table.*;

public class TableModelTest extends JPanel {
   private static final Object[][] DATA = {
         { "1", "Station 1", new Integer(10), false, new Integer(0), Color.red },
         { "2", "Station 2", new Integer(10), false, new Integer(0), Color.blue },
         { "3", "Station 3", new Integer(10), false, new Integer(0),
               Color.green },
         { "4", "Station 4", new Integer(10), false, new Integer(0),
               Color.orange },
         { "5", "Station 5", new Integer(10), false, new Integer(0),
               Color.black } };
   private MyTableModel myTableModel = new MyTableModel(DATA);
   private JTable table = new JTable(myTableModel);

   public TableModelTest() {
      setLayout(new BorderLayout());
      add(new JScrollPane(table), BorderLayout.CENTER);

      table.getColumnModel().getColumn(5)
            .setCellRenderer(new ColorCellRenderer());
      table.getColumnModel().getColumn(5).setCellEditor(new ColorCellEditor());
   }

   private static void createAndShowGui() {
      TableModelTest mainPanel = new TableModelTest();

      JFrame frame = new JFrame("TableModelTest");
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

class ColorCellEditor extends AbstractCellEditor implements TableCellEditor {

   Color currentColor;
   JButton button;
   JColorChooser colorChooser;
   JDialog dialog;
   protected static final String EDIT = "edit";

   public ColorCellEditor() {
      ActionListener actionListener = new MyActionListener();
      button = new JButton();
      button.setActionCommand(EDIT);
      button.addActionListener(actionListener);
      button.setBorderPainted(false);

      colorChooser = new JColorChooser();
      dialog = JColorChooser.createDialog(button, "Pick a Color", true,
            colorChooser, actionListener, null);
   }

   private class MyActionListener implements ActionListener {

      public void actionPerformed(ActionEvent e) {
         if (EDIT.equals(e.getActionCommand())) {
            button.setBackground(currentColor);
            colorChooser.setColor(currentColor);
            dialog.setVisible(true);

            fireEditingStopped();

         } else {
            currentColor = colorChooser.getColor();
         }
      }
   }

   public Object getCellEditorValue() {
      return currentColor;
   }

   public Component getTableCellEditorComponent(JTable table, Object value,
         boolean isSelected, int row, int column) {
      currentColor = (Color) value;
      return button;
   }
}

class ColorCellRenderer implements TableCellRenderer {
   private static final int IMG_WIDTH = 70;
   private static final int IMG_HEIGHT = 20;
   private JLabel label = new JLabel();

   @Override
   public Component getTableCellRendererComponent(JTable table, Object value,
         boolean arg2, boolean arg3, int arg4, int arg5) {
      Color color = (Color) value;
      BufferedImage img = new BufferedImage(IMG_WIDTH, IMG_HEIGHT,
            BufferedImage.TYPE_INT_RGB);
      Graphics g = img.getGraphics();
      g.setColor(color);
      g.fillRect(0, 0, IMG_WIDTH, IMG_HEIGHT);
      g.dispose();
      ImageIcon icon = new ImageIcon(img);
      label.setIcon(icon);
      return label;
   }

}

class MyTableModel extends DefaultTableModel {
   private static final String[] COLUMN_NAMES = { "Station #", "Name",
         "avg Time", "Buffer", "Buffer Parts", "Color" };

   public MyTableModel(Object[][] data) {
      super(data, COLUMN_NAMES);
   }

   @Override
   public boolean isCellEditable(int row, int col) {

      if (col == 0) {
         return false;
      } else if (col == 4) {
         boolean di = (Boolean) getValueAt(row, (col - 1));
         if (!di) {
            return false;
         } else {
            return true;
         }
      } else {
         return true;
      }
   }

   public void printDebugData() {
      int numRows = getRowCount();
      int numCols = getColumnCount();

      for (int i = 0; i < numRows; i++) {
         System.out.print("    row " + i + ":");
         for (int j = 0; j < numCols; j++) {
            Object datum = getValueAt(i, j);
            // System.out.print("  " + data[i][j]);
            System.out.print("  " + datum);
         }
         System.out.println();
      }
      System.out.println("--------------------------");
   }
}