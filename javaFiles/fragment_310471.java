import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Foo extends JFrame {

   private static final int BUTTON_COUNT = 25;

   public static void main(String[] args) {
      JPanel btnPanel = new JPanel(new GridLayout(0, 1, 0, 20));
      btnPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
      AbstractAction removeAction = new AbstractAction("Remove") {

         @Override
         public void actionPerformed(ActionEvent evt) {
            JButton src = (JButton) evt.getSource();
            JPanel container = (JPanel) src.getParent();
            container.remove(src);
            container.revalidate();
            container.repaint();
         }
      };
      for (int i = 0; i < BUTTON_COUNT; i++) {
         JButton removeBtn = new JButton(removeAction);
         btnPanel.add(removeBtn);
      }
      JPanel borderPanel = new JPanel(new BorderLayout());
      borderPanel.add(btnPanel, BorderLayout.NORTH);
      JScrollPane scrollpane = new JScrollPane(borderPanel,
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
      scrollpane.setPreferredSize(new Dimension(400, 800));

      JFrame frame = new JFrame("Foo");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(scrollpane);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }

}