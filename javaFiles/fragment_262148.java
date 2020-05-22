import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class FlashCardPanel2 extends JPanel {
   private static final long serialVersionUID = 1L;
   private static final int PREF_W = 400;
   private static final int PREF_H = PREF_W;
   private JLabel currentLabel;
   private String term = "Term";
   private String definition = "Definition: This will be a very long String to "
         + "illustrate the problem that you are having, and to try to help you get "
         + "a solution";
   private JButton editButton = new JButton("Edit");
   private JButton flipButton = new JButton(new FlipAction("Flip"));

   public FlashCardPanel2() {
      this.setLayout(new GridBagLayout());
      GridBagConstraints c = new GridBagConstraints();
      c.insets = new Insets(15, 15, 15, 15);
      currentLabel = new JLabel(term);  

      c.fill = GridBagConstraints.HORIZONTAL;
      c.weightx = 0;
      c.gridx = 0;
      c.gridy = 0;
      add(editButton, c);

      c.fill = GridBagConstraints.HORIZONTAL;
      c.ipady = 0;
      c.gridwidth = 0;
      c.weightx = 0;
      c.gridx = 2;
      c.gridy = 0;
      add(flipButton, c);

      c.fill = GridBagConstraints.HORIZONTAL;
      c.ipady = 40;
      c.weightx = 0;
      c.gridwidth = 3;
      c.gridx = 1;
      c.gridy = 3;
      add(currentLabel, c);
   }

   @Override
   public Dimension getPreferredSize() {
      if (isPreferredSizeSet()) {
         return super.getPreferredSize();
      }
      return new Dimension(PREF_W, PREF_H);
   }

   private class FlipAction extends AbstractAction {
      public FlipAction(String name) {
         super(name);
         int mnemonic = (int) name.charAt(0);
         putValue(MNEMONIC_KEY, mnemonic);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         String text = currentLabel.getText();
         text = (text.equals(term)) ? definition : term;
         currentLabel.setText(text);
      }
   }

   private static void createAndShowGui() {
      JFrame frame = new JFrame("FlashCardPanel2");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new FlashCardPanel2());
      frame.pack();
      frame.setLocationRelativeTo(null);
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