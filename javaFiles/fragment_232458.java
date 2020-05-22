import java.awt.event.ActionEvent;

import javax.swing.*;

public class Foo2 extends JPanel {
   private DefaultListModel<Integer> dataModel = new DefaultListModel<>();
   private JList<Integer> intJList = new JList<>(dataModel);

   public Foo2() {
      add(new JScrollPane(intJList));
      intJList.setFocusable(false);
      add(new JButton(new AbstractAction("Add Int") {
         private int count = 0;

         @Override
         public void actionPerformed(ActionEvent e) {
            dataModel.clear();  // if you need to clear previous entries
            dataModel.addElement(count);
            count++;
         }
      }));
   }

   private static void createAndShowGui() {
      JFrame frame = new JFrame("Foo2");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new Foo2());
      frame.pack();
      frame.setLocationRelativeTo(null);
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