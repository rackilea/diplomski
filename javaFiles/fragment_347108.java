while (gameEnd == false)
{
    DisplayBoard();
    dropColumn = GetDropColumn(turn, input);

     if (DropChecker(turn, dropColumn) == true)
     {
        turn = 'x' == turn ? 'o' : 'x'; //ternary operator works great
     }
}