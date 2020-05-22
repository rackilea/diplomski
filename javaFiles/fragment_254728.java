import java.awt.*;
import javax.swing.*;

public class Question1 {
   public static void main(String[] args) {
      MyFrame f = new MyFrame("Simple Submit Cancel Form");
      f.init();
   }
}

class MyFrame extends JFrame {
   private static final int GAP = 2;

   MyFrame(String title) {
      super(title);
   }

   private JPanel mainPanel;
   private GridBagLayout gbLayout = new GridBagLayout();

   void init() {
      mainPanel = new JPanel();
      mainPanel.setLayout(gbLayout);
      mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
      this.setContentPane(mainPanel);

      GridBagConstraints gbc = new GridBagConstraints();
      gbc.anchor = GridBagConstraints.WEST;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      gbc.insets = new Insets(GAP, GAP, GAP, GAP);
      gbc.gridwidth = 2;
      gbc.weightx = 1.0;
      gbc.weighty = 1.0;
      gbc.gridx = 0;
      gbc.gridy = 0;

      JTextField tf = new JTextField(20);

      mainPanel.add(tf, gbc);

      gbc.gridwidth = 1;
      gbc.gridx = 0;
      gbc.gridy = 1;

      JButton b = new JButton("Submit");
      mainPanel.add(b, gbc);
      b = new JButton("Cancel");
      gbc.gridx++;
      mainPanel.add(b, gbc);

      this.pack();
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setVisible(true);
   }
}