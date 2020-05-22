import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class TestMain2 extends JPanel {
   private static final String GUI_NAME = "My GUI";
   private CardLayout cardLayout = new CardLayout();
   private LoginPanel loginPanel = new LoginPanel();
   private HomePanel homePanel = new HomePanel();

   public TestMain2() {
      setLayout(cardLayout);
      add(loginPanel, LoginPanel.NAME);
      add(homePanel, HomePanel.NAME);
      for (PartyCategory partyCategory : PartyCategory.values()) {
         PartyPanel partyPanel = new PartyPanel(partyCategory.getName());
         partyPanel.addPropertyChangeListener(PartyPanel.RETURN, new PartyPanelListener());
         add(partyPanel, partyCategory.getName());
      }

      loginPanel.addPropertyChangeListener(LoginPanel.NAME, new LoginPanelListener());
      homePanel.addPropertyChangeListener(HomePanel.PARTY_CATEGORY, new HomeListener());
   }

   private class LoginPanelListener implements PropertyChangeListener {
      @Override
      public void propertyChange(PropertyChangeEvent evt) {
         if (evt.getNewValue() == Boolean.TRUE) {
            System.out.println("Submit Pressed");
            System.out.println("Login: " + loginPanel.getLogin());

            // TODO: Dangerous code!!! Delete this!!!
            System.out.println("Password: " + new String(loginPanel.getPassword())); 

            cardLayout.show(TestMain2.this, HomePanel.NAME);
         } else {
            System.out.println("Cancel Pressed");
         }
      }
   }

   private class HomeListener implements PropertyChangeListener {
      @Override
      public void propertyChange(PropertyChangeEvent evt) {
         PartyCategory partyCategory = (PartyCategory) evt.getNewValue();
         cardLayout.show(TestMain2.this, partyCategory.getName());
      }
   }

   private class PartyPanelListener implements PropertyChangeListener {
      @Override
      public void propertyChange(PropertyChangeEvent evt) {
         if (evt.getNewValue() == Boolean.TRUE) {
            cardLayout.show(TestMain2.this, HomePanel.NAME);
         }
      }
   }

   private static void createAndShowGui() {
      TestMain2 mainPanel = new TestMain2();

      JFrame frame = new JFrame(GUI_NAME);
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

@SuppressWarnings({"serial", "hiding"})
class LoginPanel extends JPanel {
   public static final String NAME = "Login";
   private static final int COLS = 10;
   private static final String EMAIL_PROMPT = "Enter Your Email Address:";
   private static final String PASSWORD_PROMPT = "Enter Your Password:";
   private boolean submitPressed = false;

   private JTextField textField = new JTextField(COLS);
   private JPasswordField passField = new JPasswordField(COLS);

   public LoginPanel() {
      JPanel buttonPanel = new JPanel(new GridLayout(1, 0, 5, 5));
      buttonPanel.add(new JButton(new ButtonAction("Submit", KeyEvent.VK_S, true)));
      buttonPanel.add(new JButton(new ButtonAction("Cancel", KeyEvent.VK_C, false)));
      buttonPanel.add(new JButton(new ExitAction()));

      JPanel innerPanel = new JPanel(new GridBagLayout());
      innerPanel.setBorder(BorderFactory.createTitledBorder(NAME));
      innerPanel.add(new JLabel(EMAIL_PROMPT, JLabel.LEADING), getGbc(0, 0));
      innerPanel.add(textField, getGbc(1, 0));
      innerPanel.add(new JLabel(PASSWORD_PROMPT, JLabel.LEADING), getGbc(0, 1));
      innerPanel.add(passField, getGbc(1, 1));
      innerPanel.add(buttonPanel, getGbc(0, 2, 2, 1));

      add(innerPanel);
   }

   public boolean isLoginValid() {
      return submitPressed;
   }

   public void setSubmitPressed(boolean submitPressed) {
      this.submitPressed = submitPressed;
      firePropertyChange(NAME, null, submitPressed);
   }

   public String getLogin() {
      return textField.getText();
   }

   public char[] getPassword() {
      return passField.getPassword();
   }

   private class ButtonAction extends AbstractAction {

      private boolean submitPressed;

      public ButtonAction(String name, int mnemonic, boolean submitPressed) {
         super(name);
         putValue(MNEMONIC_KEY, mnemonic);
         this.submitPressed = submitPressed;
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         setSubmitPressed(submitPressed);
      }
   }

   private static GridBagConstraints getGbc(int x, int y, int width, int height) {
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridx = x;
      gbc.gridy = y;
      gbc.gridwidth = width;
      gbc.gridheight = height;

      gbc.weightx = 1.0;
      gbc.weighty = 1.0;
      if (x == 1) {
         gbc.insets = new Insets(5, 15, 5, 5);
         gbc.fill = GridBagConstraints.HORIZONTAL;
         gbc.anchor = GridBagConstraints.EAST;
      } else {
         gbc.insets = new Insets(5, 5, 5, 5);
         gbc.fill = GridBagConstraints.BOTH;
         gbc.anchor = GridBagConstraints.WEST;
      }

      return gbc;
   }

   private static GridBagConstraints getGbc(int x, int y) {
      return getGbc(x, y, 1, 1);
   }   

}

@SuppressWarnings({"serial", "hiding"})
class HomePanel extends JPanel {
   public static final String NAME = "Home";
   public static final String PARTY_CATEGORY = "Party Category";
   private static final String PROMPT = "Choose Party Category:";
   private PartyCategory partyCategory = null;

   public HomePanel() {
      JPanel buttonPanel = new JPanel(new GridLayout(1, 0, 5, 5));
      for (PartyCategory partyCategory : PartyCategory.values()) {
         buttonPanel.add(new JButton(new ButtonListener(partyCategory)));
      }

      add(new JLabel(PROMPT));
      add(buttonPanel);
   }

   public PartyCategory getPartyCategory() {
      return partyCategory;
   }

   public void setPartyCategory(PartyCategory partyCategory) {
      this.partyCategory = partyCategory;
      firePropertyChange(PARTY_CATEGORY, null, partyCategory);
   }

   private class ButtonListener extends AbstractAction {
      private PartyCategory partyCategory;

      public ButtonListener(PartyCategory partyCategory) {
         super(partyCategory.getName());
         this.partyCategory = partyCategory;
         int mnemonic = partyCategory.getName().charAt(0);
         putValue(MNEMONIC_KEY, mnemonic);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         setPartyCategory(partyCategory);
      }
   }

}

enum PartyCategory {
   BIRTHDAY_PARTY("Birthday Party"),
   SUMMER_FESTIVE_PARTY("Summer/Festive Party"),
   HALLOWEEN_PARTY("Halloween Party");
   private String name;

   private PartyCategory(String name) {
      this.name = name;
   }

   public String getName() {
      return name;
   }   
}

@SuppressWarnings("serial")
class PartyPanel extends JPanel {
   public static final String RETURN = "return";
   private static final int PREF_W = 400;
   private static final int PREF_H = PREF_W;

   public PartyPanel(String name) {
      JLabel label = new JLabel(name, SwingConstants.CENTER);
      label.setFont(label.getFont().deriveFont(Font.BOLD, 48f));

      JPanel returnButtonPanel = new JPanel();
      returnButtonPanel.add(new JButton(new ReturnAction()));
      returnButtonPanel.add(new JButton(new ExitAction()));

      setLayout(new BorderLayout());
      add(label);
      add(returnButtonPanel, BorderLayout.PAGE_END);
   }

   @Override
   public Dimension getPreferredSize() {
      Dimension superSize = super.getPreferredSize();
      if (isPreferredSizeSet()) {
         return superSize;
      }
      int prefW = Math.max(superSize.width, PREF_W);
      int prefH = Math.max(superSize.height, PREF_H);
      return new Dimension(prefW, prefH);
   }

   private class ReturnAction extends AbstractAction {
      public ReturnAction() {
         super("Return Home");
         putValue(MNEMONIC_KEY, KeyEvent.VK_R);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         PartyPanel.this.firePropertyChange(RETURN, null, true);
      }
   }
}

@SuppressWarnings("serial")
class ExitAction extends AbstractAction {
   public ExitAction() {
      super("Exit");
      putValue(MNEMONIC_KEY, KeyEvent.VK_X);
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      // this will not work for JMenuItem which would require a test to see if coming
      // from a pop up first.

      Component source = (Component) e.getSource();
      Window win = SwingUtilities.getWindowAncestor(source);
      win.dispose();
   }
}