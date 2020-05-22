import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

@SuppressWarnings("serial")
public class LayoutExample extends JPanel {
   private static final float SIZE = 32;
   private static final int TIMER_DELAY = 2000;
   private String[] TITLE_STRINGS = { "Title 1", "Title 2",
         "Some Random Title", "Fubars Rule!", "Snafus Drool!" };
   private int titleIndex = 0;
   private JLabel titleLabel = new JLabel(TITLE_STRINGS[titleIndex],
         JLabel.CENTER);

   public LayoutExample() {
      titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, SIZE));

      setLayout(new BorderLayout());
      add(titleLabel, BorderLayout.PAGE_START);

      // the rest of your GUI could be added below
      add(Box.createRigidArea(new Dimension(500, 300)), BorderLayout.CENTER);

      new Timer(TIMER_DELAY, new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            titleIndex++;
            titleIndex %= TITLE_STRINGS.length;
            titleLabel.setText(TITLE_STRINGS[titleIndex]);
         }
      }).start();
   }

   private static void createAndShowGui() {
      JFrame frame = new JFrame("LayoutExample");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new LayoutExample());
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