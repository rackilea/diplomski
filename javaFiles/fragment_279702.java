public void checkGuess() {
    String guessText = txtGuess.getText();
    String message = "";
    try {

        int guess = Integer.parseInt(guessText);
        if (guess < 0 || guess >100) {
            message = "Please enter a number between 0 and 100";
            attempt++;
        }
        else if (guess < theNumber) {
            message = guess + " is too low. Try again.";
            attempt++;
        }
        else if (guess > theNumber) {
            message = guess + " is too high. Try again.";
            attempt++;
        }
        else {
            message = guess + " is correct! It took " + attempt+ " attempts. Starting new game.";
            attempt++;
            newGame();
        }
    } 
        catch(Exception e) {
        message= "Enter a whole number between 0 and 100";
    } 
        finally {
            lblOutput.setText(message);
            txtGuess.requestFocus();
            txtGuess.selectAll();
        }
}