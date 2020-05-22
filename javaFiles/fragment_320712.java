import javax.swing.JOptionPane;

public class InputDialog
{
  public static void main(String[] args)
  {
    String userInput = JOptionPane.showInputDialog(null, "What is your name?", "Input", JOptionPane.QUESTION_MESSAGE);
    System.out.println("User input: " + userInput);
  }
}