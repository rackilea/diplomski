import java.awt.GridLayout;
import javax.swing.*;

public class CalcEg {
   private static final float BTN_FONT_SIZE = 20f;  // **** try using 40f here ****
   private static final String[][] BTN_LABELS = {
      {"7", "8", "9", "-"},
      {"4", "5", "6", "+"},      
      {"1", "2", "3", "/"},
      {"0", ".", " ", "="}
   };
   private JPanel mainPanel = new JPanel();

   public CalcEg() {
      int rows = BTN_LABELS.length;
      int cols = BTN_LABELS[0].length;
      int gap = 4;
      mainPanel.setBorder(BorderFactory.createEmptyBorder(gap, gap, gap, gap));
      mainPanel.setLayout(new GridLayout(rows, cols, gap, gap));
      for (String[] btnLabelRow : BTN_LABELS) {
         for (String btnLabel : btnLabelRow) {
            JButton btn = createButton(btnLabel);
            // add ActionListener to btn here
            mainPanel.add(btn);
         }
      }
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