import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;

public class CalcEg {
   private static final float BTN_FONT_SIZE = 20f; 
   private static final String[][] BTN_LABELS = {
      {"7", "8", "9", "-"},
      {"4", "5", "6", "+"},      
      {"1", "2", "3", "/"},
      {"0", ".", " ", "="}
   };
   private static final int GAP = 4;
   private JPanel mainPanel = new JPanel(new BorderLayout(GAP, GAP));
   private JPanel buttonPanel = new JPanel();
   private JTextField display = new JTextField();

   public CalcEg() {
      int rows = BTN_LABELS.length;
      int cols = BTN_LABELS[0].length;
      buttonPanel.setLayout(new GridLayout(rows, cols, GAP, GAP));
      for (String[] btnLabelRow : BTN_LABELS) {
         for (String btnLabel : btnLabelRow) {
            if (btnLabel.trim().isEmpty()) {
               buttonPanel.add(new JLabel());
            } else {
               JButton btn = createButton(btnLabel);
               buttonPanel.add(btn);
            }
         }
      }
      display.setFont(display.getFont().deriveFont(BTN_FONT_SIZE));
      display.setEditable(false);
      display.setFocusable(false);
      display.setBackground(Color.white);

      mainPanel.setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
      mainPanel.add(buttonPanel, BorderLayout.CENTER);
      mainPanel.add(display, BorderLayout.PAGE_START);
   }

   private JButton createButton(String btnLabel) {
      JButton button = new JButton(btnLabel);
      button.setFont(button.getFont().deriveFont(BTN_FONT_SIZE));
      return button;
   }

   public JComponent getMainComponent() {
      return mainPanel;
   }

   private static void createAndShowGui() {
      CalcEg mainPanel = new CalcEg();

      JFrame frame = new JFrame("CalcEg");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(mainPanel.getMainComponent());
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