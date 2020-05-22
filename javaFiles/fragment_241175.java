import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Calculator extends JPanel {
    public static void main(String args[]) {

        JFrame f = new JFrame();

        double n1 = Double.parseDouble(JOptionPane
                .showInputDialog(" Enter first number: "));
        double n2 = Double.parseDouble(JOptionPane
                .showInputDialog(" Enter second number: "));
        String x = JOptionPane.showInputDialog("Enter operator: ");
        double result;

        if (x.equals("+")) {
            result = (n1 + n2);
            JOptionPane.showMessageDialog(f, n1 + "+" + n2 + "=" + result);
            System.out.println(x);
        }

        else if (x.equals("-")) {
            result = (n1 - n2);
            JOptionPane.showMessageDialog(f, n1 + "-" + n2 + "=" + result);
            System.out.println(x);
        }

        else if (x.equals("/")) {
            if (n2 == 0) {
                JOptionPane.showMessageDialog(null, "Cannot divide by 0");
            }else{
            result = (n1 / n2);
            JOptionPane.showMessageDialog(f, n1 + "/" + n2 + "=" + result);
            System.out.println(x);
            }
        }

        else if (x.equals("*")) {
            result = (n1 * n2);
            JOptionPane.showMessageDialog(f, n1 + "*" + n2 + "=" + result);
        }

        else if (x.equals("%")) {
            result = (n1 % n2);
            JOptionPane.showMessageDialog(f, n1 + "%" + n2 + "=" + (n1 % n2));
        }
    }
}