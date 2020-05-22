double num1;
double num2;
String inputted_text1;
String inputted_text2;

inputted_text1 = JOptionPane.showInputDialog("Enter first number: ");
num1 = Integer.parseInt(inputted_text1);
inputted_text2 = JOptionPane.showInputDialog("Enter second number:");
num2 = Integer.parseInt(inputted_text2);
if (num1 > num2) {
  JOptionPane.showMessageDialog(null, "The first number is bigger than the second number.");
} else {
  JOptionPane.showMessageDialog(null, "The second number is bigger than the first number.");
}