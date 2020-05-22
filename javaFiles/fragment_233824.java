import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ButtonGridEg extends JPanel {
   private static final int ROWS = 8;
   private static final int COLS = ROWS;
   private static final int GAP = 5;
   private JButton[][] buttonGrid = new JButton[ROWS][COLS];

   public ButtonGridEg() {
      setLayout(new GridLayout(ROWS, COLS, GAP, GAP));

      ActionListener buttonListener = new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent evt) {
            JButton selectedBtn = (JButton) evt.getSource();
            for (int row = 0; row < buttonGrid.length; row++) {
               for (int col = 0; col < buttonGrid[row].length; col++) {
                  if (buttonGrid[row][col] == selectedBtn) {
                     System.out.printf("Selected row and column: %d %d%n", row, col);
                  }
               }
            }
         }
      };
      for (int row = 0; row < buttonGrid.length; row++) {
         for (int col = 0; col < buttonGrid[row].length; col++) {
            String text = String.format("Button [%d, %d]", row, col);
            buttonGrid[row][col] = new JButton(text);
            buttonGrid[row][col].addActionListener(buttonListener);
            add(buttonGrid[row][col]);
         }
      }
   }

   private static void createAndShowGui() {
      ButtonGridEg mainPanel = new ButtonGridEg();

      JFrame frame = new JFrame("ButtonGridEg");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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