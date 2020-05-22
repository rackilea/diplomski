import java.awt.Dimension;
import javax.swing.*;

public class Gui2 extends JPanel {
   private static final int PREF_W = 500;
   private static final int PREF_H = 400;

   public Gui2() {
      JLabel label1 = new JLabel("Tell me something");
      label1.setToolTipText("Click if you need help");

      add(label1);
      JButton button1 = new JButton("OK");
      button1.setBorderPainted(true);
      button1.setContentAreaFilled(true);
      button1.setToolTipText("This is my button");
      add(button1);
      JTextField txtField = new JTextField("Type here", 15);

      txtField.setToolTipText("It's a field");
      add(txtField);
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   private static void createAndShowGui() {
      Gui2 mainPanel = new Gui2();

      JFrame frame = new JFrame("Woot I created a frame!");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.setResizable(false);
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