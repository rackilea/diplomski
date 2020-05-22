public boolean checkRow(int rowNumber)
{
    ArrayList numbersSeen = new ArrayList();

    for(int i = 0; i < 9; i += 1)
    {
        if(sudokuArray[i][rowNumber] != -1 && numbersSeen.contains(sudokuArray[i][rowNumber]))
        {
            return true;
        }
    }

    return false;
}