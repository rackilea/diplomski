import javax.swing.JOptionPane;
public class SimpleErrorMessage {
    public static void main(String[] args) {
       JOptionPane.showMessageDialog(
               null, "Error!", "Error Message", JOptionPane.ERROR_MESSAGE);
    }  
}