import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.*;

@SuppressWarnings("serial")
public class FirstPanel2 extends JPanel {
   private static final int PREF_W = 600;
   private static final int PREF_H = 300;
   private JTextField textField = new JTextField("Hovercraft rules!", 30);
   private int count = 0;

   public FirstPanel2() {
      AddAction addAction = new AddAction();
      textField.setAction(addAction);

      add(textField);
      add(new JButton(addAction));
   }

   @Override
   public Dimension getPreferredSize() {
      if (isPreferredSizeSet()) {
         return super.getPreferredSize();
      }
      return new Dimension(PREF_W, PREF_H);
   }

   private class AddAction extends AbstractAction {
      public AddAction() {
         super("Add");
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         String text = textField.getText();
         final JTextField someField = new JTextField(text, 10);
         JPanel panel = new JPanel();
         panel.add(someField);
         int result = JOptionPane.showConfirmDialog(FirstPanel2.this, panel, "Add Label",
               JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
         if (result == JOptionPane.OK_OPTION) {
            JLabel label = new JLabel(someField.getText());
            FirstPanel2.this.add(label);
            FirstPanel2.this.revalidate();
            FirstPanel2.this.repaint();
         }
      }
   }

   private static void createAndShowGui() {
      FirstPanel2 mainPanel = new FirstPanel2();

      JFrame frame = new JFrame("My Gui");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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