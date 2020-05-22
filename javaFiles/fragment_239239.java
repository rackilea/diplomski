import java.awt.BorderLayout;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
import javax.swing.text.JTextComponent;

@SuppressWarnings("serial")
public class RandomNumberGame2 extends JPanel {
   private static final int LOW = 0;
   private static final int HIGH = 100;
   public static final String START_GAME = "Please guess the random number between "
         + LOW + " and " + HIGH;
   public static final String TO_HIGH = "Your guess is too high. Please try again";
   public static final String TO_LOW = "Your guess is too low. Please try again";
   public static final String CONGRATS_YOU_WIN = "Congratulations, you win!!!";

   private Random random = new Random();
   private int randomNumber; // holds the randomly selected number
   private JTextField inputField = new JTextField(5); // where user enters guess
   private JButton submitButton = new JButton(new SubmitAction("Submit", KeyEvent.VK_S));
   private JButton resetButton = new JButton(new ResetAction("Reset", KeyEvent.VK_R));
   private JLabel statusLabel = new JLabel(START_GAME, SwingConstants.CENTER);

   public RandomNumberGame2() {
      // so field will select all when gains focus
      inputField.addFocusListener(new FocusAdapter() {
         @Override
         public void focusGained(FocusEvent e) {
            JTextComponent textComp = (JTextComponent) e.getSource();
            textComp.selectAll();
         }
      });
      // so input field will submit number if enter is pressed
      inputField.addActionListener(submitButton.getAction());

      JPanel centerPanel = new JPanel(); // uses flow layout by default
      centerPanel.add(new JLabel("Enter number here:"));
      centerPanel.add(inputField);
      centerPanel.add(submitButton);
      centerPanel.add(resetButton);

      setLayout(new BorderLayout());
      add(statusLabel, BorderLayout.PAGE_START);
      add(centerPanel, BorderLayout.CENTER);

      resetGame();
   }

   public void resetGame() {
      randomNumber = random.nextInt(HIGH - LOW) + LOW;
      inputField.setText("");
      statusLabel.setText(START_GAME);
      inputField.requestFocusInWindow();
      inputField.selectAll();
   }

   private class SubmitAction extends AbstractAction {
      public SubmitAction(String name, int mnemonic) {
         super(name);
         putValue(MNEMONIC_KEY, mnemonic);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         try {
            int input = Integer.parseInt(inputField.getText().trim());
            if (input > randomNumber) {
               statusLabel.setText(TO_HIGH);
            } else if (input < randomNumber) {
               statusLabel.setText(TO_LOW);
            } else {
               statusLabel.setText(CONGRATS_YOU_WIN);
            }
            inputField.requestFocusInWindow();
            inputField.selectAll();

         } catch (NumberFormatException e1) {
            JOptionPane.showMessageDialog(RandomNumberGame2.this,
                  "Please enter only integer data", "Non-numeric Data Error",
                  JOptionPane.ERROR_MESSAGE);
            inputField.setText("");
         }
      }
   }

   private class ResetAction extends AbstractAction {
      public ResetAction(String name, int mnemonic) {
         super(name);
         putValue(MNEMONIC_KEY, mnemonic);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         resetGame();
      }
   }

   private static void createAndShowGui() {
      RandomNumberGame2 mainPanel = new RandomNumberGame2();

      JFrame frame = new JFrame("Fun Games 2");
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