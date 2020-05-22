public int[] convertNumtoDigitArray()   //Java saying this line is a problem
{
    String[] userGuessSplit = Player.userGuess.split(",");
    int[] userGuessArray = new int[userGuessSplit.length];
    for (int j=0; j<userGuessSplit.length; j++)
    {
        userGuessArray[j] = Integer.parseInt(userGuessSplit[j]);
    }
    return userGuessArray;
}