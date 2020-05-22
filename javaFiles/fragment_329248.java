import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class Sscce2 extends JPanel {
   private static final String COMMUNITY = "Community";
   private static final String PASSWORD = "Password";
   private static final String BLANK = "Blank";
   private static final String[] VERSIONS = {COMMUNITY, PASSWORD, BLANK};

   CardLayout cardLayout = new CardLayout();
   JPanel cardHolderPanel = new JPanel(cardLayout);
   JComboBox combobox = new JComboBox(VERSIONS);
   private JPasswordField passwordField = new JPasswordField(15);
   private JTextField communityTextField = new JTextField(15);

   public Sscce2() {
      cardHolderPanel.add(createCommunityPanel(), COMMUNITY);
      cardHolderPanel.add(createPasswordPanel(), PASSWORD);
      cardHolderPanel.add(new JLabel(), BLANK);

      JPanel comboPanel = new JPanel();
      comboPanel.setLayout(new BoxLayout(comboPanel, BoxLayout.PAGE_AXIS));
      comboPanel.setBorder(BorderFactory.createTitledBorder("Version:"));
      comboPanel.add(combobox);

      setLayout(new GridLayout(0, 1));
      add(comboPanel);
      add(cardHolderPanel);

      combobox.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            String selection = combobox.getSelectedItem().toString();
            cardLayout.show(cardHolderPanel, selection);
         }
      });
   }

   public String getCommunityText() {
      return communityTextField.getText();
   }

   public char[] getPassword() {
      return passwordField.getPassword();
   }


   private JPanel createCommunityPanel() {
      JPanel panel = new JPanel();
      panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
      panel.setBorder(BorderFactory.createTitledBorder(COMMUNITY));
      panel.add(communityTextField);
      return panel;
   }


   private JPanel createPasswordPanel() {
      JPanel panel = new JPanel();
      panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
      panel.setBorder(BorderFactory.createTitledBorder(PASSWORD));
      panel.add(passwordField);
      return panel;
   }


   private static void createAndShowGui() {
      Sscce2 sscce2 = new Sscce2();
      JOptionPane.showMessageDialog(null, sscce2, "SSCCE 2", JOptionPane.PLAIN_MESSAGE);

      System.out.println("Community text: " + sscce2.getCommunityText());
      System.out.println("Password: " + new String(sscce2.getPassword())); // *** never do this!
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}