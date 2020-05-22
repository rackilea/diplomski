import javax.swing.JOptionPane;
public class ConsoleTest {
    public static void main(String[] args) {
        if (System.console() == null) {
            JOptionPane.showMessageDialog(null, "System.console() is null");
        } else {
           JOptionPane.showMessageDialog(null, "System.console() is not null");
        }
    }
}