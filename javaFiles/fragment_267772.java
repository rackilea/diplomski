import java.awt.event.ActionEvent;
import javax.swing.*;

public class ActionWithMultipleBehaviors extends JPanel {
   private TimerButtonAction timerBtnAction = new TimerButtonAction("Start", "Reset");
   private JButton timerButton = new JButton(timerBtnAction);

   public ActionWithMultipleBehaviors() {
      add(timerButton);
   }

   class TimerButtonAction extends AbstractAction {
      private boolean stateStart = true;
      private String name;
      private String secondName;

      public TimerButtonAction(String name, String secondName) {
         super(name);
         this.name = name;
         this.secondName = secondName;
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         String newName;
         if (stateStart) {
            newName = secondName;

            // TODO: add start timer code

         } else {
            newName = name;

            // TODO: add reset timer code

         }
         putValue(NAME, newName);
         stateStart = !stateStart;
      }
   }

   private static void createAndShowGui() {
      ActionWithMultipleBehaviors mainPanel = new ActionWithMultipleBehaviors();

      JFrame frame = new JFrame("ActionWithMultipleBehaviors");
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