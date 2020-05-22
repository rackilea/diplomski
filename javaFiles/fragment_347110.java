private static boolean DropChecker(char turn, int dropColumn)
{
    int indexToPaceChecker = BOARD_HEIGHT;
    while (indexToPaceChecker >= 0)
    {
        if (board[indexToPaceChecker][dropColumn] == ' ')
        {
            //drop the checker, that's what this method is supposed to do anyways :)
            board[indexToPaceChecker][dropColumn] = turn;
            return true;
        }
        indexToPaceChecker--;
    }
    return false;
}