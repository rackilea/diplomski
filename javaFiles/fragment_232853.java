// code corrected
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Registration extends JPanel {
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