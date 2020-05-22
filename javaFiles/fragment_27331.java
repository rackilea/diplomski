import javax.swing.JOptionPane;
public class RandomGuessMatch {
public static void main(String[] args) {
    int random_Number, difference;
    String user_Number;
    String random;

    random_Number = 1 + (int) (Math.random() * 100);
    System.out.println(random_Number);

    user_Number = JOptionPane.showInputDialog(null,
            "Please guess a number between 1 to 5." + "Please input your number", "Guessing Game",
            JOptionPane.INFORMATION_MESSAGE);

    JOptionPane.showMessageDialog(null,
            "The difference between my number and your number is "
                    + (Integer.parseInt(user_Number) - random_Number),
            "Guessing Game", JOptionPane.INFORMATION_MESSAGE);

    boolean valid = (random_Number == Integer.parseInt(user_Number));
    JOptionPane.showMessageDialog(null, "Does your number and my number match?" + "\n" + valid, "Guessing Game",
            JOptionPane.INFORMATION_MESSAGE);
}
}