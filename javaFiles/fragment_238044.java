import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class FirstFrame extends JPanel {
   private static final int PREF_W = 400;
   private static final int PREF_H = 300;
   private Login login = new Login(this);
   private Register register = new Register(this);
   private CardLayout cardLayout = new CardLayout();

   public FirstFrame() {
      setLayout(cardLayout);
      add(login, Login.class.toString());
      add(register, Register.class.toString());
   }

   public void swapCards(String key) {
      cardLayout.show(this, key);
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   private static void createAndShowGui() {
      FirstFrame mainPanel = new FirstFrame();

      JFrame frame = new JFrame("FirstFrame");
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

class SwapCardAction extends AbstractAction {
   private String key;
   private FirstFrame firstFrame;

   public SwapCardAction(String name, int mnemonic, String key,
         FirstFrame firstFrame) {
      super(name);
      this.key = key;
      this.firstFrame = firstFrame;
      putValue(MNEMONIC_KEY, mnemonic);
   }

   @Override
   public void actionPerformed(ActionEvent evt) {
      firstFrame.swapCards(key);
   }
}

class Register extends JPanel {

   public Register(final FirstFrame firstFrame) {
      setBackground(new Color(255, 200, 200));
      JButton gotToLoginBtn = new JButton(new SwapCardAction("Login",
            KeyEvent.VK_L, Login.class.toString(), firstFrame));
      JPanel btnPanel = new JPanel();
      btnPanel.setOpaque(false);
      btnPanel.add(gotToLoginBtn);

      setLayout(new BorderLayout());
      JLabel label = new JLabel("Register", SwingConstants.CENTER);
      add(label, BorderLayout.CENTER);
      add(btnPanel, BorderLayout.SOUTH);
   }

}

class Login extends JPanel {

   public Login(FirstFrame firstFrame) {
      JButton gotToRegisterBtn = new JButton(new SwapCardAction("Register",
            KeyEvent.VK_R, Register.class.toString(), firstFrame));
      setBackground(new Color(150, 200, 255));
      JPanel btnPanel = new JPanel();
      btnPanel.add(gotToRegisterBtn);
      btnPanel.setOpaque(false);

      setLayout(new BorderLayout());
      JLabel label = new JLabel("Login", SwingConstants.CENTER);
      add(label, BorderLayout.CENTER);
      add(btnPanel, BorderLayout.SOUTH);
   }

}