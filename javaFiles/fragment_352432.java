import javax.swing.JOptionPane;

public class TestOptionPane {
   public static void main(String[] args) {
      int result = JOptionPane.showConfirmDialog(null, "This is a test",
            "Test", JOptionPane.YES_NO_OPTION);

      System.out.println("result: " + result);

      switch (result) {
      case JOptionPane.YES_OPTION:
         System.out.println("Yes Pressed");
         break;
      case JOptionPane.NO_OPTION:
         System.out.println("No Pressed");
         break;
      case JOptionPane.CLOSED_OPTION:
         System.out.println("Dialog closed");
         break;    
      default:
         System.out.println("Default");
         break;
      }
   }
}