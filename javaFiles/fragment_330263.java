import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.*;

public class Window2 extends JFrame {
   private static final long serialVersionUID = 1L;
   private static final int PREF_W = 600;
   private static final int PREF_H = 400;

   public Window2() {

      super("ALANAZ imagtor");
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      int gap = 3;
      JPanel buttonPanel = new JPanel(new GridLayout(1, 0, gap, 0));
      buttonPanel.setBorder(BorderFactory.createEmptyBorder(gap, gap, gap, gap));
      JPanel pnl2 = new JPanel();

      JButton butn1 = new JButton("EXIT");
      JButton butn2 = new JButton("IMPORT");

      butn1.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "exiting ... bye...");
            System.exit(0);
         }
      });
      butn2.addActionListener(new ActionListener() {

         public void actionPerformed(ActionEvent ae) {
            JOptionPane.showMessageDialog(null, "can't import now exiting");
            System.exit(0);
         }
      });

      JLabel lbl1 = new JLabel("exit or import an image");
      buttonPanel.add(butn1);
      buttonPanel.add(butn2);


      JPanel centerPanel = new JPanel(new BorderLayout());
      centerPanel.add(buttonPanel, BorderLayout.SOUTH);

      pnl2.add(lbl1);
      add(pnl2, BorderLayout.SOUTH);
      add(centerPanel, BorderLayout.CENTER);
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   public static void main(String[] args) {
      Window2 win2 = new Window2();
      win2.pack();
      win2.setLocationRelativeTo(null);
      win2.setVisible(true);
   }
}