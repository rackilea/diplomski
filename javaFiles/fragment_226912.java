public class GraphicalUserInterface {
    public static void main(String [] args) {  //  <=========

        String first_number = JOptionPane.showInputDialog("Enter first number");
        String second_number = JOptionPane.showInputDialog("Enter second number");

        int num1 = Integer.parseInt(first_number);
        int num2 = Integer.parseInt(second_number);
        int sum = num1 + num2;

        JOptionPane.showMessageDialog(null, "The answer is " +sum, "The Title", JOptionPane.INFORMATION_MESSAGE);

   } //  <=========
}