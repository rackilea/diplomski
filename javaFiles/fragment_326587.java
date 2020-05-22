public void actionPerformed ( ActionEvent event )
{
    inputGuess = Integer.parseInt( guessInput.getText() );
    test[i]= inputGuess;
    processGuessedNumber( inputGuess );
    i++;

}