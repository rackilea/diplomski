import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;

public class Test4 extends JPanel {
   private static final long serialVersionUID = 1L;
   private static final int GAP = 3;

   public Test4() {
      JPanel buttonHoldingPanel = new JPanel(new GridLayout(3, 3, GAP, GAP));
      buttonHoldingPanel.add(new JButton("Process"));
      buttonHoldingPanel.add(new JButton("Arrival Time"));
      buttonHoldingPanel.add(new JButton("Quanta Time"));
      buttonHoldingPanel.add(new JButton("woooo"));
      buttonHoldingPanel.add(new JLabel());
      buttonHoldingPanel.add(new JLabel());
      buttonHoldingPanel.add(new JButton("LdsdaE"));
      buttonHoldingPanel.add(new JLabel());
      buttonHoldingPanel.add(new JLabel());

      setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
      setLayout(new BorderLayout());
      add(buttonHoldingPanel, BorderLayout.PAGE_START);
      add(Box.createRigidArea(new Dimension(400, 300)), BorderLayout.CENTER);
   }

   private static void createAndShowGui() {
      Test4 mainPanel = new Test4();

      JFrame frame = new JFrame("Test4");
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