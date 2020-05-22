import java.awt.event.ActionEvent;
import javax.swing.*;

public class JRockPaperEtc2 extends JApplet {
   private static final String FORMAT_TXT = "Tally: %03d";
   private int tally = 0;
   private JLabel lblTally = new JLabel(String.format(FORMAT_TXT, tally));

   @Override
   public void init() {
      JPanel mainPanel = new JPanel();

      // lblTally = new JLabel("Tally: 000"); // *** no shadowing
      mainPanel.add(lblTally);

      JButton button = new JButton(new AbstractAction("Push") {

         @Override
         public void actionPerformed(ActionEvent e) {
            tally++;
            lblTally.setText(String.format(FORMAT_TXT, tally));
            // *** lblTally's text is now changed
         }
      });
      mainPanel.add(button);

      add(mainPanel);
   }
}