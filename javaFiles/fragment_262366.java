import java.awt.Dimension;

import javax.swing.*;

public class SpinnerBigTextField {
   private static void createAndShowGui() {
      JSpinner spinner = new JSpinner(new SpinnerNumberModel(0.0, 0.0, 999.0,
            0.5));

      JPanel panel = new JPanel();
      panel.setPreferredSize(new Dimension(300, 100));
      panel.add(spinner);

      JComponent field = ((JSpinner.DefaultEditor) spinner.getEditor());
      Dimension prefSize = field.getPreferredSize();
      prefSize = new Dimension(200, prefSize.height);
      field.setPreferredSize(prefSize);

      JFrame frame = new JFrame("SpinnerBigTextField");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(panel);
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