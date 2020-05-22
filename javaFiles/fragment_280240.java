import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.*;

public class Test2 {
   private static void createAndShowGui() {
      JPanel mainPanel = new JPanel(new GridBagLayout());
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridx = 0;
      gbc.gridy = 0;
      gbc.gridheight = 1;
      gbc.gridwidth = 1;
      gbc.weightx = 1.0;
      gbc.weighty = 1.0;
      gbc.fill = GridBagConstraints.BOTH;
      gbc.anchor = GridBagConstraints.PAGE_START;

      mainPanel.add(new JLabel("Look at me!", SwingConstants.CENTER), gbc);   


      gbc.gridy = 1;
      gbc.gridheight = 10;
      gbc.gridwidth = 10;

      mainPanel.add(Box.createRigidArea(new Dimension(400, 400)), gbc);

      JFrame frame = new JFrame("Test2");
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