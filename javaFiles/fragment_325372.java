import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class ComboFun {
   private static JComboBox<Character> skillLevelCombo;

   public static void main(String[] args) {
      Character[] levels = {'0', '1', '2', '3'};
      skillLevelCombo = new JComboBox<Character>(levels); 

      JOptionPane.showMessageDialog(null, skillLevelCombo);
   }
}