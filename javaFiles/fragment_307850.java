do
{
    drawGallows();
    displayWord();
    getGuess();
    checkGuess();
    // ---> You should check win here
    if(corLetters == word.length())
        gameOver = true;

}
while(incGuessCount<5 && gameOver == false);