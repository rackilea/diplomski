import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class MultiSizedPanels {

   private static void createAndShowUI() {
      final CardLayout cardLayout = new CardLayout();
      final JPanel cardHolder = new JPanel(cardLayout);

      JLabel[] labels = {
         new JLabel("Small Label", SwingConstants.CENTER),
         new JLabel("Medium Label", SwingConstants.CENTER),
         new JLabel("Large Label", SwingConstants.CENTER)};

      for (int i = 0; i < labels.length; i++) {
         int padding = 50;
         Dimension size = labels[i].getPreferredSize();
         size = new Dimension(size.width + 2 * (i + 1) * padding, size.height + 2 * (i + 1) * padding);
         labels[i].setPreferredSize(size);
         Border lineBorder = BorderFactory.createLineBorder(Color.blue);
         labels[i].setBorder(lineBorder);
         JPanel containerPanel = new JPanel(new GridBagLayout());
         containerPanel.add(labels[i]);
         cardHolder.add(containerPanel, String.valueOf(i));
      }

      JButton nextButton = new JButton("Next");
      nextButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            cardLayout.next(cardHolder);
         }
      });
      JPanel btnHolder = new JPanel();
      btnHolder.add(nextButton);

      JFrame frame = new JFrame("MultiSizedPanels");
      frame.getContentPane().add(cardHolder, BorderLayout.CENTER);
      frame.getContentPane().add(btnHolder, BorderLayout.SOUTH);

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