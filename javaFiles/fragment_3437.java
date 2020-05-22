public class Assignment1 extends JFrame implements ActionListener {

    // declare variables
    int x = 101;
    int low = 0;
    int high = 100;
    int guess = (high + low) / 2;
    int counter = 0;
    JLabel bottomLabel;  // <==


    public Assignment1() {
        // [...] other assignments
        bottomLabel = new JLabel("Game Over, your number is NN, i got it in N times. Wanna play again?");
        // [...] rest of class