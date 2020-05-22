package guessinggame;

import javax.swing.JOptionPane;

public class Guessinggame {

public static void main(String[] args) {

    int guess;
    int numguess = 0;
    int usernum;

  while(true) { //Start of while loop

    int result = JOptionPane.showConfirmDialog(null, " Do you want to play? ", " Notice ", JOptionPane.YES_NO_OPTION);

    if (result == JOptionPane.YES_OPTION) {

        do {
            //game starts here
            guess = (int) (Math.random() * 100 + 1);
            usernum = Integer.parseInt(JOptionPane.showInputDialog("enter your guess"));
            numguess++;

            if (usernum > guess) {
                System.out.println(usernum + " is too high. Try again");
            } else if (usernum < guess) {
                System.out.println(usernum + " is too low. Try again");
            }
        } while (guess != usernum);

        int IQ = ((int) (Math.random() * 100 + 1)) + numguess;
        JOptionPane.showMessageDialog(null, " Correct, it took you " + numguess + " tries. Your IQ is " + IQ);

        //Use showConfirmDialog to if player wants to play again. 
        // If user chooses yes, play game again. If user chooses no end game
    } else if (result == JOptionPane.NO_OPTION) {
        JOptionPane.showMessageDialog(null, "Quiting? Bye!");
        System.exit(0);
    }

  } //End of While Loop

}

}