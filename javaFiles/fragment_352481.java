import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class Main {
    public static void main(String[] args) {

        JList<String> choice = new JList<>(new String[] {
                "Enter the complaints", "View complaints" });
        int result = JOptionPane.showConfirmDialog(null,
                new JScrollPane(choice), "Multi-select Example",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result != JOptionPane.OK_OPTION) {
            // they didn't press OK
            return;
        }
        if (choice.getSelectedIndex() == 0) {
            System.out.println("Complaints App");
        } else if (choice.getSelectedIndex() == 1) {
            System.out.println("Complaints View");
        }
    }
}