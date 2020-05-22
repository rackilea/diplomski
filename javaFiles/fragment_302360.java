import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ButtonPressedEg {
   public static void main(String[] args) {
      int timerDelay = 100;
      final Timer timer = new Timer(timerDelay , new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            System.out.println("Button Pressed!");
         }
      });

      JButton button = new JButton("Press Me!");
      final ButtonModel bModel = button.getModel();
      bModel.addChangeListener(new ChangeListener() {

         @Override
         public void stateChanged(ChangeEvent cEvt) {
            if (bModel.isPressed() && !timer.isRunning()) {
               timer.start();
            } else if (!bModel.isPressed() && timer.isRunning()) {
               timer.stop();
            }
         }
      });

      JPanel panel = new JPanel();
      panel.add(button);


      JOptionPane.showMessageDialog(null, panel);

   }
}