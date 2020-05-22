import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyGui extends JPanel {
   public static final String[] DATA = {"One\n1", "Two\n2", "Three\n3"};
   private DefaultListModel listModel = new DefaultListModel();
   private JList list = new JList(listModel);

   public MyGui() {
      list.setCellRenderer(new Listm(3, 30));
      add(new JScrollPane(list));
      for (String datum : DATA) {
         listModel.addElement(datum);
      }
   }

   private class Listm extends JTextArea implements ListCellRenderer {
      protected Listm(int rows, int cols) {
         super(rows, cols);
         setBorder(BorderFactory.createLineBorder(Color.blue));
      }

      public Component getListCellRendererComponent(JList list, Object value,
               int index, boolean isSelected, boolean cellHasFocus) {
         setText(value.toString());
         if (cellHasFocus) {
            setBackground(FOCUSED_COLOR);
         } else if (isSelected) {
            setBackground(SELECTED_COLOR);
         } else {
            setBackground(null);
         }
         return this;
      }
   }

   private static void createAndShowUI() {
      JFrame frame = new JFrame("MyGui");
      frame.getContentPane().add(new MyGui());
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