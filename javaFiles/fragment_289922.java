while(test.gameOver==false)//Continue to get user guess until win or lose
{
    test.getGuess(test.board, test.bombBoard);
    test.displayBoard(test.board);
}
test.finishGame(); // Game is over, close all resources