import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class FlashCardPanel3 extends JPanel {
   private static final long serialVersionUID = 1L;
   private static final String CURRENT_LABEL = "current label";
   private static final String DEFINITION = "definition";
   private JLabel currentLabel;
   private JTextArea currentDefinitionArea = new JTextArea(6, 20);
   private CardLayout cardLayout = new CardLayout();
   private JPanel cardHolder = new JPanel(cardLayout);
   private String term = "Term";
   private String definition = "Definition: This will be a very long String to "
         + "illustrate the problem that you are having, and to try to help you get "
         + "a solution";
   private JButton editButton = new JButton("Edit");
   private JButton flipButton = new JButton(new FlipAction("Flip"));

   public FlashCardPanel3() {
      currentDefinitionArea.setOpaque(false);
      currentDefinitionArea.setText(definition);
      currentDefinitionArea.setWrapStyleWord(true);
      currentDefinitionArea.setLineWrap(true);
      currentDefinitionArea.setEditable(false);
      currentDefinitionArea.setFocusable(false);

      currentLabel = new JLabel(term, SwingConstants.CENTER);
      cardHolder.add(currentLabel, CURRENT_LABEL);
      cardHolder.add(new JScrollPane(currentDefinitionArea), DEFINITION);

      JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 5, 0));

      buttonPanel.add(editButton);
      buttonPanel.add(flipButton);

      setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
      setLayout(new BorderLayout(5, 5));
      add(buttonPanel, BorderLayout.PAGE_START);
      add(cardHolder);
   }

   private class FlipAction extends AbstractAction {
      public FlipAction(String name) {
         super(name);
         int mnemonic = (int) name.charAt(0);
         putValue(MNEMONIC_KEY, mnemonic);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         // String text = currentLabel.getText();
         // text = (text.equals(term)) ? definition : term;
         // currentLabel.setText(text);
         cardLayout.next(cardHolder);
      }
   }

   private static void createAndShowGui() {
      JFrame frame = new JFrame("FlashCardPanel2");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new FlashCardPanel3());
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