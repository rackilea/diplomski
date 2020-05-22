//while game is not complete
if (gameStatus == "CONTINUE") {
    sumOfDice = rollDice();  //roll dice again  !!! remove this line !!!

    // determine game status
    if (sumOfDice == myPoint) // win by making point
    {
....