import java.awt.*;
import javax.swing.*;

public class CopyTextNorthPanel2 extends JPanel {

   private static final long serialVersionUID = 1L;
   public JTextField northField;

   public CopyTextNorthPanel2() {
      northField = new JTextField("Welcome World");
      northField.setFont(new Font("Serif", Font.BOLD, 20));
      northField.setPreferredSize(new Dimension(300, 25));
      add(northField);
   }

   public String getNorthFieldText() {
      return northField.getText();
   }
}