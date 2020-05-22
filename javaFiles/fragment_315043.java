import java.awt.GridLayout;
import javax.swing.*;

public class Foo003 {
   public static void main(String[] args) {
      JButton upButton = new JButton("Up");
      JButton downButton = new JButton("Down");
      JButton leftButton = new JButton("Left");
      JButton rightButton = new JButton("Right");
      JComponent[][] components = { 
            { new JLabel(), upButton, new JLabel() },
            { leftButton, new JLabel(), rightButton },
            { new JLabel(), downButton, new JLabel() } };

      JPanel panel = new JPanel(new GridLayout(components.length,
            components[0].length, 8, 8));
      for (int i = 0; i < components.length; i++) {
         for (int j = 0; j < components[i].length; j++) {
            panel.add(components[i][j]);
         }
      }

      int eb = 15;
      panel.setBorder(BorderFactory.createEmptyBorder(eb, eb, eb, eb));

      JFrame frame = new JFrame("Grid e.g.");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(panel);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }
}