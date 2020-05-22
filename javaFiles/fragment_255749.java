import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

class LifeCycle2  {
   private static final int GAP = 5;
   private static final int PREF_W = 545;
   private static final int PREF_H = 340;
   private JPanel mainPanel = new JPanel() {
      @Override
      public Dimension getPreferredSize() {
         return LifeCycle2.this.getPreferredSize();
      }
   };

   public LifeCycle2() {
      JPanel buttonPanel = new JPanel(new GridLayout(1, 0, GAP, 0));
      buttonPanel.add(new JButton("A"));
      buttonPanel.add(new JButton("B"));
      buttonPanel.setOpaque(false);
      JPanel flowLayoutPanel = new JPanel();
      flowLayoutPanel.setOpaque(false);
      flowLayoutPanel.add(buttonPanel);

      mainPanel.setLayout(new BorderLayout());
      mainPanel.setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
      mainPanel.setBackground(Color.red);
      mainPanel.add(flowLayoutPanel, BorderLayout.NORTH);
   }

   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   public JComponent getMainPanel() {
      return mainPanel;
   }
}