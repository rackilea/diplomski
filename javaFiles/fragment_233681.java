import javax.swing.JOptionPane;

class NumberFrom1To100
{
    public static void main(String[] args) {

        boolean stillplaying = true;
        double answer = 53;
        double userAnswer;
        String userInput;

        while (stillplaying) {
            userInput = JOptionPane.showInputDialog("Guess a number between 1 and 100.");
            userAnswer = Double.parseDouble(userInput);

            if (userAnswer < 53) {
                JOptionPane.showMessageDialog(null, "You picked a number LESS than the mystery number. Try again.");
            } else if (userAnswer > 53) {
                JOptionPane.showMessageDialog(null, "You picked a number GREATER than the mystery number. Try again.");
            } else {
                JOptionPane.showMessageDialog(null, "Congratulations! You just won 5 brownie points!");
            }
        }

        // System.exit(0);
    }
}