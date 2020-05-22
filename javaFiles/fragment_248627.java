import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class TestMain {
   private static void createAndShowGui() {
      LoginForm loginForm = new LoginForm();
      loginForm.pack();
      loginForm.setVisible(true);

   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}

class LoginForm extends JFrame {

   private JLabel loginEmail;
   private JLabel loginPass;
   private JTextField loginTextField;
   private JPasswordField loginPassField;
   private JButton submit;
   private JPanel loginArea;
   private JPanel buttonArea;

   public LoginForm() {
      super("Party Supplies Rental");
      setLayout(new FlowLayout());

      loginEmail = new JLabel("Enter Your Email Address: ");
      loginTextField = new JTextField(20);
      loginPass = new JLabel("Enter Your Password: ");
      loginPassField = new JPasswordField(20);

      loginArea = new JPanel();
      loginArea.setLayout(new GridLayout(2, 2));

      loginArea.add(loginEmail); // add to the JPanel
      loginArea.add(loginTextField);
      loginArea.add(loginPass);
      loginArea.add(loginPassField);
      add(loginArea); // add JPanel to the frame

      submit = new JButton("Submit");
      buttonArea = new JPanel();
      buttonArea.setLayout(new GridLayout(1, 2));
      buttonArea.add(submit);
      add(buttonArea);

      ButtonHandler handler = new ButtonHandler();

      submit.addActionListener(handler);

   }

   public class ButtonHandler implements ActionListener {
      public void actionPerformed(ActionEvent event) {
         if (event.getSource() == submit) {
            dispose();
            Main main = new Main();
            main.pack();
            main.setVisible(true);
         }
      }
   }

}

class Main extends JFrame {

   private JLabel label;
   private JPanel forLabel;
   private JButton birthdayCategory;
   private JButton summerCategory;
   private JButton halloweenCategory;
   private JPanel forCategory;

   public Main() {
      super("Home");
      setLayout(new FlowLayout());

      label = new JLabel("Choose the Party Category");
      forLabel = new JPanel();
      forLabel.setLayout(new GridLayout(1, 3));
      forLabel.add(label);
      add(forLabel);

      birthdayCategory = new JButton("Birthday Party");
      summerCategory = new JButton("Summer/Festive Party");
      halloweenCategory = new JButton("Halloween Party");
      forCategory = new JPanel();
      forCategory.setLayout(new GridLayout(1, 3));
      forCategory.add(birthdayCategory);
      forCategory.add(summerCategory);
      forCategory.add(halloweenCategory);
      add(forCategory);
   }

}