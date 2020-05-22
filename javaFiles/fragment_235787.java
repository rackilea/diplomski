import java.awt.event.*;
import javax.swing.*;

public class CopyTextSouthPanel2 extends JPanel {

   private static final long serialVersionUID = 1L;
   private JTextField firstText = new JTextField("Desired TextField");
   private JButton copyButton = new JButton("Copy text from JTextFields");
   private CopyTextControl2 control;

   public CopyTextSouthPanel2() {
      copyButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if (control != null) {
               control.copyAction();
            }
         }
      });

      add(firstText);
      add(copyButton);
   }

   public void setControl(CopyTextControl2 control) {
      this.control = control;
   }

   public void setFirstText(String text) {
      firstText.setText(text);
   }
}