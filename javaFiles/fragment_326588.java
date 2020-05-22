import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GuessGame extends JFrame {
Container container;
int currentDistance;

int inputGuess;
int lastDistance;
int medianValue = 40;
int middleNumber;
int positionIndex = 5;
int test[] = new int[20];
int num_of_guess = 0;

private JButton newGame;
private JLabel message;
private JLabel prompt;
private JLabel numberInput;
private JTextField guessInput;
private int countGuess;
private int randomNumber;

public GuessGame() {
    super("Play Guess A Number Game Version 2.1");
    setLayout(new FlowLayout());

    countGuess = 0;

    prompt = new JLabel("A random number between N and 100 has been"
            + " selected.");
    numberInput = new JLabel("Write your number and press enter key: ");

    guessInput = new JTextField(5);
    guessInput.addActionListener(new GuessHandler());
    message = new JLabel("The result will be shown here.");

    newGame = new JButton("Start New Game");
    newGame.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent event) {

            guessInput.setText("");
            guessInput.setEditable(true);

            generateNumber();

        }
    });

    container = getContentPane();
    container.add(prompt);
    container.add(numberInput);
    container.add(guessInput);
    container.add(message);
    container.add(newGame);

    setSize(380, 150);
    setVisible(true);

    generateNumber();

}

private void generateNumber() {
    randomNumber = (int) (Math.random() * 93 + 7);
    // randomNumber = 45;
    System.out.println(randomNumber);

}

public void processGuessedNumber(int usersGuess) {
    countGuess++;

    if (countGuess == 1) {
        lastDistance = Math.abs(usersGuess - randomNumber);

        if (usersGuess > randomNumber)
            message.setText("Higher than correst guess.");
        else
            message.setText("Lower than correct guess.");

    }

    else {
        currentDistance = Math.abs(usersGuess - randomNumber);

        if (usersGuess > randomNumber) {
            message.setText("Higher than correct guess.");

            lastDistance = currentDistance;

        }

        else if (usersGuess < randomNumber) {
            message.setText("Lower than correct guess.");

            lastDistance = currentDistance;

        }

        else {
            message.setText("Congratulations, your guess is correct!");

            guessInput.setEditable(false);
            countGuess = 0;

            findMiddleNumber();
        }
    }
}

public void findMiddleNumber() {
    /*
     * int num_of_guesses = 0;
     * 
     * Scanner inputs = new Scanner( System.in );
     * 
     * int [] testArray = new int[ 20 ];
     * 
     * do { if ( inputGuess != randomNumber ) {
     * 
     * 
     * {inputGuess = inputs.nextInt();
     * System.out.println("inputGuess:"+inputGuess); }
     * 
     * 
     * } else testArray[ num_of_guesses ] = inputGuess;
     * System.out.println("testarr "
     * +num_of_guesses+" :"+testArray[num_of_guesses]); num_of_guesses++;
     * 
     * if ( inputGuess >= randomNumber) { break; }
     * 
     * } while ( inputGuess != randomNumber);
     */

    middleNumber = test[(num_of_guess) / 2];

    System.out.printf("\nMiddle is: " + middleNumber);

    finalOutput();
}

public void finalOutput() {
    JOptionPane.showMessageDialog(null, "Congratulations, your guess "
            + "is correct." + "\n\n1. Middle number from all guessed "
            + "numbers by the user is: " + middleNumber + "\n\r2. Median "
            + " value of all guessed numbers by the user is: "
            + medianValue + "\n\r3. A position (array index) of correctly "
            + "guessed number in sorted array is: " + positionIndex,
            "Final Output", JOptionPane.PLAIN_MESSAGE);

}

public static void main(String[] args) {
    GuessGame application = new GuessGame();
    application.setDefaultCloseOperation(EXIT_ON_CLOSE);

}

class GuessHandler implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent event) {
        inputGuess = Integer.parseInt(guessInput.getText());
        // System.out.println("inputGuess"+inputGuess);
        test[num_of_guess] = inputGuess;
        //System.out.println(num_of_guess + ":" + test[num_of_guess]);
        processGuessedNumber(inputGuess);
        num_of_guess++;

    }
}
}