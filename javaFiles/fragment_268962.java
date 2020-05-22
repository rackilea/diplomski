while (gameNotOver())
{
    if (!playerList[currentPlayer].skipNextTurn())
    {
        //do what you would normally do
    }
    else
    {
        playerList[currentPlayer].setSkipNextTurn(false);
    }
}