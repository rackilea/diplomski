for(int i = 0; i <characters ; i++)
{
    randomNumberArray[i] = random;
    // If not first, check if it matches the previous digit
    while(i >= 1 && randomNumberArray[i - 1] == random)
    {
        random = (int)(Math.random()*9);
        randomNumberArray[i] = random;
    }
}