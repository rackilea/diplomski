char[][] stringToChar(String[][] stringArray)
{
    char[][] charArray = new char[stringArray.length][stringArray[0].length]
    for(int i = 0; i < stringArray.length; i++)
    {
        for(int j = 0; j < stringArray[0].length; j++)
        {
            charArray[i][j] = stringArray[i][j].charAt(0);
        }
    }
}