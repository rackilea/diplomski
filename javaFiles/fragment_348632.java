public void actionPerformed (ActionEvent e) {
    String tc = random(); //A method that chooses a random word.
    them.setText("They chose: " + tc + "!"); 
    if (choice == rock) {
        whoWins("rock", tc); //whoWins is a method that will display a message.
    } else if (choice == paper) {
        whoWins("paper", tc);
    } else if (choice == scissors) {
        whoWins("scissors", tc);
    }
    yourWins.setText("Your wins: " + yw);
    theirWins.setText("Their wins: " + tw);

    // Start another Timer here that waits 1 second
    // and re-enables the other buttons...
}