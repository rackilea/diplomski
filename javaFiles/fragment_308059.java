import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

class MainClass implements ReceiveAction {
   private JPanel mainPanel = new JPanel();
   private JMenuBar menuBar = new JMenuBar();
   private JMenu chooseViewMenu = new JMenu("Choose View");

   public MainClass() {
      Registration registration = new Registration();
      ButtonPanel buttonPanel = new ButtonPanel();

      ReceiveAction[] recActions = {this, buttonPanel};
      new ViewSwapControl(registration, recActions);

      buttonPanel.setBorder(BorderFactory.createTitledBorder("Button Panel"));
      registration.setBorder(BorderFactory.createTitledBorder("Registration Panel"));

      mainPanel.setLayout(new BorderLayout());
      mainPanel.add(registration, BorderLayout.CENTER);
      mainPanel.add(buttonPanel, BorderLayout.SOUTH);

      menuBar.add(chooseViewMenu);
   }

   public JComponent getMainPanel() {
      return mainPanel;
   }

   public JMenuBar getMenuBar() {
      return menuBar ;
   }

   @Override
   public void addAction(Action action) {
      chooseViewMenu.add(new JMenuItem(action));
   }

   private static void createAndShowUI() {
      MainClass mainInstance = new MainClass();


      JFrame frame = new JFrame("Registration");
      frame.getContentPane().add(mainInstance.getMainPanel());
      frame.setJMenuBar(mainInstance.getMenuBar());
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            createAndShowUI();
         }
      });
   }

}

class ViewSwapControl {
   private Registration registration;
   private List<Action> actionList = new ArrayList<>(); 

   public ViewSwapControl(Registration registration, ReceiveAction... recActions) {
      this.registration = registration;
      for (final String keyText : Registration.KEY_TEXTS) {
         actionList.add(new MyAction(keyText));
      }
      for (ReceiveAction receiveAction : recActions) {
         for (Action action : actionList) {
            receiveAction.addAction(action);
         }
      }
   }

   @SuppressWarnings("serial")
   private class MyAction extends AbstractAction {
      public MyAction(String name) {
         super(name);
      }

      @Override
      public void actionPerformed(ActionEvent evt) {
         if (registration != null) {
            registration.swapView(getValue(NAME).toString());
         }
      }
   }

}

interface ReceiveAction {
   public void addAction(Action action);
}

@SuppressWarnings("serial")
class ButtonPanel extends JPanel implements ReceiveAction {

   public ButtonPanel() {
      setLayout(new GridLayout(1, 0, 10, 0));
   }

   @Override
   public void addAction(Action action) {
      add(new JButton(action));
   }
}

@SuppressWarnings("serial")
class Registration extends JPanel {
   // use these same constants as button texts later
   private static final Dimension PREF_SIZE = new Dimension(450, 300);
   public static final String USER_AGREEMENT = "User Agreement";
   public static final String USER_INFO = "User Information";
   public static final String ENROLLMENT = "Enrollment";
   // we'll extract them from this array
   public static final String[] KEY_TEXTS = {USER_AGREEMENT, USER_INFO, ENROLLMENT};
   private CardLayout cardlayout = new CardLayout();
   private JPanel cards = new JPanel(cardlayout);

   public Registration() {
      cards.add(createUserAgreePanel(), USER_AGREEMENT);
      cards.add(createUserInfoPanel(), USER_INFO);
      cards.add(createEnrollmentPanel(), ENROLLMENT);
      setLayout(new BorderLayout());
      add(cards, BorderLayout.CENTER);
   }

   @Override
   public Dimension getPreferredSize() {
      return PREF_SIZE;
   }

   private JPanel createEnrollmentPanel() {
      JPanel enrol = new JPanel();
      enrol.add(new JLabel("Enrollment"));
      return enrol;
   }

   private JPanel createUserAgreePanel() {
      JPanel userAgree = new JPanel();
      userAgree.add(new JLabel("User Agreement"));
      return userAgree;
   }

   private JPanel createUserInfoPanel() {
      JPanel userInfo = new JPanel();
      userInfo.add(new JLabel("User Information"));
      return userInfo;
   }

   public void swapView(String key) {
      cardlayout.show(cards, key);
   }

}