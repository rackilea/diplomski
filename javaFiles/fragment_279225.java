import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ComboBoxArrowListener {
   private static void createAndShowUI() {
      String[] data = {"One", "Two", "Three"};
      JComboBox combo = new JComboBox(data);
      JPanel panel = new JPanel();
      panel.add(combo);

      JButton arrowBtn = getButtonSubComponent(combo);
      if (arrowBtn != null) {
         arrowBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               System.out.println("arrow button pressed");
            }
         });
      }

      JFrame frame = new JFrame("ComboBoxArrowListener");
      frame.getContentPane().add(panel);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }

   private static JButton getButtonSubComponent(Container container) {
      if (container instanceof JButton) {
         return (JButton) container;
      } else {
         Component[] components = container.getComponents();
         for (Component component : components) {
            if (component instanceof Container) {
               return getButtonSubComponent((Container)component);
            }
         }
      }
      return null;
   }

   public static void main(String[] args) {
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            createAndShowUI();
         }
      });
   }
}