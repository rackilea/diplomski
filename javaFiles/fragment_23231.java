import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class NestedJOptions {
   public static void main(String[] args) {
      final JPanel panel = new JPanel();
      panel.add(new JButton(new AbstractAction("Push Me") {
         public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(panel, "hello world!");
         }
      }));

      JOptionPane.showMessageDialog(null, panel);
   }
}