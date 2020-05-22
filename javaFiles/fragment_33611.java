import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TestJFormattedText {
   public static void main(String[] args) {
      NumberFormat format = NumberFormat.getNumberInstance();
      format.setGroupingUsed(false);
      final JFormattedTextField formattedField = new JFormattedTextField(format);
      formattedField.setColumns(10);

      formattedField.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent arg0) {
            long value = ((Long)formattedField.getValue()).longValue();
            if (value > 5000) {
               formattedField.setValue(5000);
            }
         }
      });


      JPanel panel = new JPanel();
      panel.add(formattedField);
      JFrame frame = new JFrame("Foo");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.add(panel);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }
}