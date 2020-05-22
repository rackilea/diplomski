import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OptionPaneTest {

public static void main(String[] args) {
    JPanel myPanel = new JPanel();
    JTextField field1 = new JTextField(10);
    JTextField field2 = new JTextField(10);
    myPanel.add(field1);
    myPanel.add(field2);
    JOptionPane.showMessageDialog(null, myPanel);
    System.out.println(field1.getText() + field2.getText());
}
}