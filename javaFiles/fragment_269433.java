public static boolean luhmAlgorith(String num)
{
    boolean bool;
    char[] numAsCharArray = num.toCharArray();
    int cardSum = 0;
    for (int i = 0; i <= num.length(); i++)
    {
        cardSum += Integer.parseInt(String.valueOf(numAsCharArray[i]));
    }
    if (cardSum % 10 == 0)
    {
        bool = true;
    }
    else
    {
        bool = false;
    }
    return bool;
}