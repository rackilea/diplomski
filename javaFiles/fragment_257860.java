import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class SwapFields {
   private static final String TEXT_FIELD = "text field";
   private static final String PASS_FIELD = "pass field";

   public SwapFields() {
      // TODO Auto-generated constructor stub
   }

   private static void createAndShowGui() {
      final JTextField textField = new JTextField(10);
      final JPasswordField passwordField = new JPasswordField(10);

      final CardLayout cardLayout = new CardLayout();
      final JPanel cardPanel = new JPanel(cardLayout);
      cardPanel.add(textField, TEXT_FIELD);
      cardPanel.add(passwordField, PASS_FIELD);

      JToggleButton toggleBtn = new JToggleButton("Entering Password");
      toggleBtn.addItemListener(new ItemListener() {

         @Override
         public void itemStateChanged(ItemEvent iEvt) {
            if (iEvt.getStateChange() == ItemEvent.SELECTED) {
               cardLayout.show(cardPanel, PASS_FIELD);
               passwordField.requestFocusInWindow();
            } else {
               cardLayout.show(cardPanel, TEXT_FIELD);
               textField.requestFocusInWindow();
            }
         }
      });

      JButton showNamePasswordBtn = new JButton("Show Results");
      showNamePasswordBtn.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent arg0) {
            System.out.println("Name: " + textField.getText());

            // never do this!
            System.out.println("Pass: " + new String(passwordField.getPassword()));
         }
      });

      JPanel mainPanel = new JPanel();
      mainPanel.add(cardPanel);
      mainPanel.add(toggleBtn);
      mainPanel.add(showNamePasswordBtn);

      JFrame frame = new JFrame("SwapFields");
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